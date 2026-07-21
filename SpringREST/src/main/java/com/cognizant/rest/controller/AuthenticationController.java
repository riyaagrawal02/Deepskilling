package com.cognizant.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.rest.model.AuthRequest;
import com.cognizant.rest.model.AuthResponse;
import com.cognizant.rest.service.AuthenticationService;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationService authenticationService;
    
  
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        try {
            AuthResponse response = authenticationService.authenticate(authRequest);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    

    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestParam String token) {
        if (authenticationService.validateToken(token)) {
            String username = authenticationService.getUsernameFromToken(token);
            return ResponseEntity.ok("Token is valid for user: " + username);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token is invalid");
        }
    }
    
    @GetMapping("/test")
    public ResponseEntity<String> testAuthenticated() {
        return ResponseEntity.ok("This is a protected endpoint - JWT validation successful!");
    }
}
