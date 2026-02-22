package com.project.indriver_backend_sb.services;

import com.project.indriver_backend_sb.dto.role.RoleDTO;
import com.project.indriver_backend_sb.dto.user.CreateUserRequest;
import com.project.indriver_backend_sb.dto.user.CreateUserResponse;
import com.project.indriver_backend_sb.dto.user.LoginRequest;
import com.project.indriver_backend_sb.dto.user.LoginResponse;
import com.project.indriver_backend_sb.models.Role;
import com.project.indriver_backend_sb.models.User;
import com.project.indriver_backend_sb.models.UserHasRoles;
import com.project.indriver_backend_sb.repositories.RoleRepository;
import com.project.indriver_backend_sb.repositories.UserHasRolesRepository;
import com.project.indriver_backend_sb.repositories.UserRepository;
import com.project.indriver_backend_sb.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserHasRolesRepository userHasRolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Transactional
    public CreateUserResponse create(CreateUserRequest request){
        if (userRepository.existsByEmail(request.email)){
            throw new RuntimeException("El correo ya esta registrado ");
        }
        User user = new User();
        user.setName(request.name);
        user.setLastName(request.lastName);
        user.setPhone(request.phone);
        user.setEmail(request.email);

        String encryptedPassword = passwordEncoder.encode(request.password);
        user.setPassword(encryptedPassword);

        User savedUser =  userRepository.save(user);
        Role clientRole = roleRepository.findById("CLIENT").orElseThrow(() -> new RuntimeException("El rol de cliente no existe"));

        UserHasRoles userHasRoles = new UserHasRoles(savedUser, clientRole);
        userHasRolesRepository.save(userHasRoles);

        CreateUserResponse response = new CreateUserResponse();
        response.setId(savedUser.getId());
        response.setName(savedUser.getName());
        response.setLastName(savedUser.getLastName());
        response.setEmail(savedUser.getEmail());
        response.setPhone(savedUser.getPhone());
        response.setImage(savedUser.getImage());

        List<Role> roles = roleRepository.findAllByUserHasRoles_User_Id(savedUser.getId());
        List<RoleDTO> rolesDTO = roles.stream()
            .map(role -> new RoleDTO(role.getId(), role.getName(), role.getImage(), role.getRoute()))
            .toList();

        response.setRoles(rolesDTO);


        return response;
    }

    @Transactional
    public LoginResponse login(LoginRequest request){
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Email no encontrado"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtUtil.generateToken(user);

        List<Role> roles = roleRepository.findAllByUserHasRoles_User_Id(user.getId());
        List<RoleDTO> rolesDTO = roles.stream()
                .map(role -> new RoleDTO(role.getId(), role.getName(), role.getImage(), role.getRoute()))
                .toList();

        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setId(user.getId());
        createUserResponse.setName(user.getName());
        createUserResponse.setLastName(user.getLastName());
        createUserResponse.setEmail(user.getEmail());
        createUserResponse.setPhone(user.getPhone());
        createUserResponse.setImage(user.getImage());
        createUserResponse.setRoles(rolesDTO);

        LoginResponse response = new LoginResponse();
        response.setToken("Bearer " + token);
        response.setUser(createUserResponse);

        return response;
    }

    @Transactional
    public CreateUserResponse findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<Role> roles = roleRepository.findAllByUserHasRoles_User_Id(user.getId());
        List<RoleDTO> rolesDTO = roles.stream()
                .map(role -> new RoleDTO(role.getId(), role.getName(), role.getImage(), role.getRoute()))
                .toList();

        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setId(user.getId());
        createUserResponse.setName(user.getName());
        createUserResponse.setLastName(user.getLastName());
        createUserResponse.setEmail(user.getEmail());
        createUserResponse.setPhone(user.getPhone());
        createUserResponse.setImage(user.getImage());
        createUserResponse.setRoles(rolesDTO);

        return createUserResponse;
    }

}
