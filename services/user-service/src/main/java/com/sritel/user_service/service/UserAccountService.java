package com.sritel.user_service.service;

import com.sritel.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountService {

    private final UserRepository userRepository;


    public boolean changePassword(String currentPassword, String newPassword) {

    }
}
