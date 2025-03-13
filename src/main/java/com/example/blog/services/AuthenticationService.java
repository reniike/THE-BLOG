package com.example.blog.services;

import com.example.blog.dtos.AuthResponse;
import com.example.blog.dtos.requests.LoginRequest;
import com.example.blog.dtos.requests.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {

    AuthResponse authenticate(LoginRequest loginRequest);

    String generateToken(UserDetails userDetails);

    UserDetails validateToken(String token);

    AuthResponse register(RegisterRequest request);
}
