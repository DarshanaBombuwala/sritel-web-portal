package com.sritel.user_service.service;

import com.sritel.user_service.model.User;
import com.sritel.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAccountService {

    private final UserRepository userRepository;


    public boolean changePassword(String currentPassword, String newPassword) {
    return true;
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUserName(username);
    }
}
