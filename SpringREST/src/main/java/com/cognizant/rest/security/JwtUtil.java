package com.cognizant.rest.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;


@Component
public class JwtUtil {
    
    @Value("${jwt.secret:MySecureSecretKeyForJWTTokenGenerationAndValidation12345}")
    private String jwtSecret;
    
    @Value("${jwt.expiration:86400000}")
    private long jwtExpirationInMs;
    

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
        
        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
    
    
    public String getUsernameFromToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    
   
    public boolean validateToken(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
            
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            System.err.println("Invalid JWT token: " + e.getMessage());
            return false;
        }
    }
    
  
    public long getExpirationTime() {
        return jwtExpirationInMs;
    }
}
