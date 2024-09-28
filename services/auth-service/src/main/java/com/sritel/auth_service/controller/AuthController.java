package com.sritel.auth_service.controller;

import com.sritel.auth_service.feignclient.UserDataClient;
import com.sritel.auth_service.model.JwtRequest;
import com.sritel.auth_service.service.JwtService;
import com.sritel.auth_service.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("authentication")
public class AuthController {

    @Autowired
    private UserInfoService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDataClient userDataClient;

    @PostMapping("/login")
    public String authenticateAndGetToken(@RequestBody JwtRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUserName());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}

