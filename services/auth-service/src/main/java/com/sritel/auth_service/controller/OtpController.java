package com.sritel.auth_service.controller;
import com.sritel.auth_service.dto.OtpVerificationDto;
import com.sritel.auth_service.service.OtpService;
import com.sritel.auth_service.dto.OtpRequestDto;
import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

import static com.twilio.example.ValidationExample.ACCOUNT_SID;
import static com.twilio.example.ValidationExample.AUTH_TOKEN;

@RestController
@RequestMapping("otp")
@RequiredArgsConstructor
public class OtpController {

    private final OtpService otpService;

    private ConcurrentHashMap<String, String> otpCache = new ConcurrentHashMap<>();

    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(@RequestBody OtpRequestDto otpRequest) {
        Twilio.init(System.getenv("TWILIO_ACCOUNT_SID"), System.getenv("TWILIO_AUTH_TOKEN"));

        try {
            // Use phone number from request
//            String phoneNumber = "+94"+otpRequest.getMobileNumber().toString();
            String phoneNumber = "+94788886171";

            // Create and send OTP
            Verification verification = Verification.creator(
                            "VAe545522581b54399c3d2d4695d878fb5", // Replace with your Twilio Verification Service SID
                            phoneNumber,
                            "sms") // Channel type, can be "sms" or "call"
                    .create();

            // Store verification SID if needed for tracking
            otpCache.put(phoneNumber, verification.getSid());

            return new ResponseEntity<>("Your OTP has been sent to your phone number.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to send OTP. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody OtpVerificationDto otpVerification) {
        Twilio.init(System.getenv("TWILIO_ACCOUNT_SID"), System.getenv("TWILIO_AUTH_TOKEN"));

        try {
            // Verification Service SID
            String verificationServiceSid = "VAe545522581b54399c3d2d4695d878fb5";

            // Extract phone number and OTP from the request body
//            String phoneNumber = "+94"+otpVerification.getMobileNumber().toString();
            String phoneNumber = "+94788886171";
            String code = otpVerification.getOtp();

            // Perform verification check
            VerificationCheck verificationCheck = VerificationCheck.creator(verificationServiceSid)
                    .setTo(phoneNumber)
                    .setCode(code)
                    .create();

            // Check verification status
            if (!"approved".equals(verificationCheck.getStatus())) {
                return new ResponseEntity<>("Verification failed. Invalid code.", HttpStatus.BAD_REQUEST);
            }

//            return new ResponseEntity<>("", HttpStatus.OK);


        } catch (Exception e) {
            return new ResponseEntity<>("Verification failed due to an internal error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("User verification completed successfully.", HttpStatus.OK);
    }



}
