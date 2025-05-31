package com.learn.hub.services;

import com.learn.hub.DTOs.LoginRequest;
import com.learn.hub.DTOs.SignupRequest;
import com.learn.hub.models.User;
import com.learn.hub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = this.userRepository.findByEmail(username);
        if (user == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

    public User verify(LoginRequest requete) {
        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(requete.getEmail(), requete.getPassword())
        );
        return (User) auth.getPrincipal();
    }

    public User signupUser(SignupRequest request) {
        User newUser = User.builder()
            .firstname(request.getFirstname())
            .lastname(request.getLastname())
            .role(request.getRole())
            .email(request.getEmail())
            .build();
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        this.userRepository.save(newUser);
        Authentication auth = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        return (User) auth.getPrincipal();
    }
}
