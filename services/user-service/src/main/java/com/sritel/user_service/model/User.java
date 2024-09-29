package com.sritel.user_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="user_details")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String email;

    private String firstName;

    private String lastName;

    private int mobileNumber;

    private String userName;

    private String password;

    private String Status;

    private String roles;


}
