package com.sritel.user_service.service;

import com.sritel.user_service.model.User;
import com.sritel.user_service.repository.UserRepository;
import com.sritel.user_service.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAccountService {

    private final UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public boolean changePassword(String currentPassword, String newPassword) {
        String existingPassword = userRepository.getPasswordByUserName(jwtUtil.extractUsername((String) SecurityContextHolder.getContext().getAuthentication().getCredentials()));


        if (passwordEncoder.matches(currentPassword, existingPassword)) {

            String encodedNewPassword = passwordEncoder.encode(newPassword);


            return userRepository.updateExistingPassword(encodedNewPassword);
        }

        return false; // Return false if the password does not match or update fails
    }


    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUserName(username);
    }
}
