package com.learn.hub.DTOs;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "email is missing")
    @Email(message = "invalid email")
    private String email;

    @NotBlank(message = "passsword id missing")
    @Size(min = 8, message = "password must have at least 8 caracters")
    private String password;
}
