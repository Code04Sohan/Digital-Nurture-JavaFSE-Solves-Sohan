package com.cognizant.jwt_learn.controller;

import com.cognizant.jwt_learn.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start authenticate()");
        
        // 1. Extract Base64 encoded credentials (removes "Basic " prefix)
        String base64Credentials = authHeader.substring(6);
        
        // 2. Decode the username and password
        byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(decodedBytes); // Results in "user:pwd"
        
        // 3. Split to get the username (index 0)
        String[] authArray = credentials.split(":");
        String username = authArray[0];
        
        // 4. Generate Token
        String token = jwtUtil.generateToken(username);
        
        // 5. Return as JSON mapping {"token": "..."}
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        
        LOGGER.info("End authenticate()");
        return response;
    }
}