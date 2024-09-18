package com.sritel.auth_service.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OtpService {

    private final Map<Integer, String> otpStore = new HashMap<>();


    public void sendOtp(Integer mobileNumber) {
        String generatedOtp = generateOtp();
        otpStore.put(mobileNumber, generatedOtp);

        System.out.println("Sending OTP: " + generatedOtp + " to " + mobileNumber);
    }

    public boolean verifyOtp(Integer mobileNumber, String otp) {
        String storedOtp = otpStore.get(mobileNumber); // Retrieve stored OTP
        return storedOtp != null && storedOtp.equals(otp);
    }

    private String generateOtp() {
        return String.valueOf((int)(Math.random() * 9000) + 1000); // Generate random 4-digit OTP
    }
}
