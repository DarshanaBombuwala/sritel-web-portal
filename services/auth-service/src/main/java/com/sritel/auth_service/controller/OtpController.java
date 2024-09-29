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
    public ResponseEntity<String> sendOtp(@RequestBody OtpRequestDto otpRequest){
        Twilio.init(System.getenv("TWILIO_ACCOUNT_SID"), System.getenv("TWILIO_AUTH_TOKEN"));
        Verification verification = Verification.creator(
                        "VAe545522581b54399c3d2d4695d878fb5",
                        "+94788886171", //this is your Twilio verified recipient phone number
                        "sms") // this is your channel type
                .create();

        otpCache.put("+94788886171", verification.getSid());

        return new ResponseEntity<>("Your OTP has been sent to your verified phone number", HttpStatus.OK);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<String> verifyOtp(@RequestBody OtpVerificationDto otpVerification) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        try {
            String cachedVerificationSid = otpCache.get("+94788886171");

            VerificationCheck verificationCheck = VerificationCheck.creator(
                            "VAe545522581b54399c3d2d4695d878fb5")
                    .setTo("+94788886171")
                    .setCode("486578")
                    .create();

            if (!"approved".equals(verificationCheck.getStatus())) throw new IllegalStateException("");

        } catch (Exception e) {
            return new ResponseEntity<>("Verification failed.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("This user's verification has been completed successfully", HttpStatus.OK);
    }

}
