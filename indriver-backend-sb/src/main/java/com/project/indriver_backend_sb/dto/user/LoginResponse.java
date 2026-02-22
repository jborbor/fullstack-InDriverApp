package com.project.indriver_backend_sb.dto.user;

import lombok.Data;

@Data
public class LoginResponse {

    private String token;
    private CreateUserResponse user;

}
