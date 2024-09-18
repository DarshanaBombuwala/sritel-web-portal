package com.sritel.auth_service.controller;
import com.sritel.auth_service.dto.OtpVerificationDto;
import com.sritel.auth_service.service.OtpService;
import com.sritel.auth_service.dto.OtpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("otp")
@RequiredArgsConstructor
public class OtpController {

    private final OtpService otpService;

    @PostMapping("/send-otp")
    public ResponseEntity<Void> sendOtp(@RequestBody OtpRequestDto otpRequest){
        otpService.sendOtp(otpRequest.getMobileNumber());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<Boolean> verifyOtp(@RequestBody OtpVerificationDto otpVerification) {
        boolean isValid = otpService.verifyOtp(otpVerification.getMobileNumber(), otpVerification.getOtp());
        return ResponseEntity.ok(isValid);
    }
}
