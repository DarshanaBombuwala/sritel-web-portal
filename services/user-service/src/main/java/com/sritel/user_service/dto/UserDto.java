package com.sritel.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

    private int userId;
    private String firstName;
    private String lastname;
    private String userName;
    private String password;
    private String email;
    private Integer mobileNumber;
    private String roles;
}
