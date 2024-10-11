package com.sritel.auth_service.controller;

import com.sritel.auth_service.feignclient.UserDataClient;
import com.sritel.auth_service.model.JwtRequest;
import com.sritel.auth_service.service.JwtService;
import com.sritel.auth_service.service.UserInfoDetails;
import com.sritel.auth_service.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> authenticateAndGetToken(@RequestBody JwtRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
            if (authentication.isAuthenticated()) {
                UserInfoDetails userInfoDetails = (UserInfoDetails) authentication.getPrincipal();
                int userId = userInfoDetails.getUserId();
                return new ResponseEntity<>(jwtService.generateToken(userInfoDetails, userId), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid username or password.", HttpStatus.BAD_REQUEST);
            }
        }catch(Exception exception){
            exception.printStackTrace();
            return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

