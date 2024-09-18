package com.sritel.user_service.service;

import com.sritel.user_service.dto.MobileNumberDto;
import com.sritel.user_service.dto.OtpVerificationDto;
import com.sritel.user_service.feignclient.OtpClient;
import com.sritel.user_service.model.User;
import com.sritel.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final OtpClient otpClient;

    public void registerCustomer(User newUser) {

        userRepository.save(newUser);
    }


    public void sendOTP(MobileNumberDto mobileNumberDto) {
        otpClient.sendOTP(mobileNumberDto);
    }

    public ResponseEntity<String> verifyOtp(OtpVerificationDto otpVerificationDto) {

        return otpClient.verifyOtp(otpVerificationDto);
    }
}
