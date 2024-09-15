package com.sritel.auth_service.controller;

import com.sritel.auth_service.config.JwtTokenUtil;
import com.sritel.auth_service.model.JwtRequest;
import com.sritel.auth_service.model.JwtResponse;
import com.example.authservice.service.JwtUserDetailsService;
import com.sritel.auth_service.config.JwtTokenUtil;
import com.sritel.auth_service.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody JwtRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}

