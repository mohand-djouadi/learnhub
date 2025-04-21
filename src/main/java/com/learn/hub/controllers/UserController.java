package com.learn.hub.controllers;

import com.learn.hub.DTOs.LoginRequest;
import com.learn.hub.DTOs.SignupRequest;
import com.learn.hub.models.User;
import com.learn.hub.services.JwtService;
import com.learn.hub.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;

    @PostMapping(value = "/login")
    public ResponseEntity<Map<String,Object>> login(@RequestBody @Valid LoginRequest request) {
        Map<String,Object> response = new HashMap<>();
        User verifiedUser = this.userService.verify(request);
        String token = jwtService.createToken(verifiedUser);
        response.put("firstname", verifiedUser.getFirstname());
        response.put("lastname", verifiedUser.getLastname());
        response.put("email", verifiedUser.getEmail());
        response.put("token", token);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<Map<String,Object>> signup(@RequestBody @Valid SignupRequest request) {
        Map<String,Object> response = new HashMap<>();
        User signedUser = this.userService.signupUser(request);
        String token = this.jwtService.createToken(signedUser);
        response.put("firstname", signedUser.getFirstname());
        response.put("lastname", signedUser.getLastname());
        response.put("email", signedUser.getEmail());
        response.put("token", token);
        return ResponseEntity.status(200).body(response);
    }

}
