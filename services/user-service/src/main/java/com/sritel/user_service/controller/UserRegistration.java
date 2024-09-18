package com.sritel.user_service.controller;

import com.sritel.user_service.dto.MobileNumberDto;
import com.sritel.user_service.dto.OtpVerificationDto;
import com.sritel.user_service.dto.UserDto;
import com.sritel.user_service.feignclient.OtpClient;
import com.sritel.user_service.model.User;
import com.sritel.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserRegistration {

    private final UserService userService;
    private final OtpClient otpClient;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto){

        User newUser = User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastname())
                .email(userDto.getEmail())
                .mobileNumber(userDto.getMobileNumber())
                .password(userDto.getPassword())
                .build();

        userService.registerCustomer(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body("Customer registered successfully");
    }

    @PostMapping("getOtp")
    public void getOTP(@RequestBody MobileNumberDto mobileNumberDto){
        userService.sendOTP(mobileNumberDto);
    }

    @PostMapping("verifyOtp")
    public boolean verifyOtp(@RequestBody OtpVerificationDto otpVerificationDto) {
        ResponseEntity<String> response = userService.verifyOtp(otpVerificationDto);
        return response.getStatusCode() == HttpStatus.OK;
    }

}
