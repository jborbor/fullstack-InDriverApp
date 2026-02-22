package com.project.indriver_backend_sb.dto.user;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;
    private String password;

}
