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
        String username = jwtUtil.extractUsername((String) SecurityContextHolder.getContext().getAuthentication().getCredentials());
        String existingPassword = userRepository.getPasswordByUserName(username);

        if (passwordEncoder.matches(currentPassword, existingPassword)) {
            String encodedNewPassword = passwordEncoder.encode(newPassword);

            // Update password in repository
            if (userRepository.updateExistingPassword(encodedNewPassword, username) > 0) {
                return true;
            }
        }
        return false;
    }



    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUserName(username);
    }
}
