package com.cognizant.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.rest.model.AuthRequest;
import com.cognizant.rest.model.AuthResponse;
import com.cognizant.rest.security.JwtUtil;

@Service
public class AuthenticationService {
    
    @Autowired
    private JwtUtil jwtUtil;
    
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password123";
 
    public AuthResponse authenticate(AuthRequest authRequest) {
        if (VALID_USERNAME.equals(authRequest.getUsername()) && 
            VALID_PASSWORD.equals(authRequest.getPassword())) {
            
            String token = jwtUtil.generateToken(authRequest.getUsername());
            return new AuthResponse(token, authRequest.getUsername(), jwtUtil.getExpirationTime());
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }
    

    public boolean validateToken(String token) {
        return jwtUtil.validateToken(token);
    }
    
    public String getUsernameFromToken(String token) {
        return jwtUtil.getUsernameFromToken(token);
    }
}
