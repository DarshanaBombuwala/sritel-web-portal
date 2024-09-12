package com.sritel.auth_service.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtRequest implements Serializable {
    private String username;
    private String password;

    // Getters and Setters
}