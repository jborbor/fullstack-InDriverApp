package com.project.indriver_backend_sb.services;

import com.project.indriver_backend_sb.dto.user.CreateUserRequest;
import com.project.indriver_backend_sb.models.User;
import com.project.indriver_backend_sb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User create(CreateUserRequest request){
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

        return userRepository.save(user);
    }

}
