package com.sritel.user_service.feignclient;

import com.sritel.user_service.dto.MobileNumberDto;
import com.sritel.user_service.dto.OtpVerificationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("auth-service")
public interface OtpClient {

    @PostMapping("auth/send-otp")
    void sendOTP(@RequestBody MobileNumberDto mobileNumberDto);

    @PostMapping("auth/verify-otp")
    ResponseEntity<String> verifyOtp(@RequestBody OtpVerificationDto otpVerificationDto);
}
