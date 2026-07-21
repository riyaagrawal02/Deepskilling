package com.cognizant.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/hello")
public class HelloWorldController {
    
    
    @GetMapping("/world")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World from Spring REST API!");
    }
    
    
    @GetMapping("/greeting")
    public ResponseEntity<String> greeting() {
        return ResponseEntity.ok("Welcome to Spring REST Application with JWT Authentication");
    }
    
    
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Application is running successfully");
    }
}
