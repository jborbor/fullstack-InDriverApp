package com.project.indriver_backend_sb.controllers;

import com.project.indriver_backend_sb.dto.user.CreateUserRequest;
import com.project.indriver_backend_sb.models.User;
import com.project.indriver_backend_sb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody CreateUserRequest request){
        User user = userService.create(request);
        return ResponseEntity.ok(user);
    }

}
