package com.sritel.auth_service.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Here you can fetch user details from DB or static data
        if ("user".equals(username)) {
            return new org.springframework.security.core.userdetails.User("user", "$2a$10$7.qD/8n.y.w6BRD7ktvse.3o3E5FLZ/J7wR/VtN0hy8UzeCEQlH6C", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}