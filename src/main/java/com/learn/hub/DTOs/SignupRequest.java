package com.learn.hub.DTOs;

import com.learn.hub.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupRequest {

    @NotBlank(message = "firstname is missing")
    private String firstname;
    @NotBlank(message = "lastname is missing")
    private String lastname;
    @NotBlank(message = "email is missing")
    @Email(message = "invalid email")
    private String email;
    @NotBlank(message = "password is missing")
    @Size(min = 8, message = "password must have at least 8 caracteres")
    private String password;
    @NotNull
    private Role role;

}
