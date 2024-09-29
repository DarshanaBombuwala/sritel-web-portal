package com.sritel.auth_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private Integer mobileNumber;
    private String roles;
}
