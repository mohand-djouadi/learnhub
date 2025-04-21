package com.learn.hub.configs;

import com.learn.hub.customExceptions.JwtTokenInvalidException;
import com.learn.hub.customExceptions.JwtTokenMissingException;
import com.learn.hub.customExceptions.UserNotExistOrAuthenticatedException;
import com.learn.hub.models.User;
import com.learn.hub.services.JwtService;
import com.learn.hub.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain
    ) throws ServletException, IOException {
        if (request.getServletPath().equals("/users/login") ||
            request.getServletPath().equals("/users/signup")
        ) {
            filterChain.doFilter(request, response);
            return;
        }
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new JwtTokenMissingException("jwt token is missing");
        }
        String jwtToken = authHeader.substring(7);
        User user = (User) userService.loadUserByUsername(jwtService.extractSubject(jwtToken));
        if (user == null) {
             throw new UserNotExistOrAuthenticatedException("user not found for this token or is already authenticated");
        }
        if (!jwtService.isTokenValid(jwtToken, user)) {
            throw new JwtTokenInvalidException("jwt token is invalid");
        }
        UsernamePasswordAuthenticationToken authtoken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        authtoken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authtoken);
        filterChain.doFilter(request, response);
    }
}
