package com.sritel.user_service.controller;

import com.sritel.user_service.dto.PasswordChangeDto;
import com.sritel.user_service.model.User;
import com.sritel.user_service.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class UserAccountController {

    private final UserAccountService userAccountService;

    @PostMapping("/change-password")
    public ResponseEntity<String> changePassword(@RequestBody PasswordChangeDto passwordChangeDto) {
        boolean isPasswordChanged = userAccountService.changePassword(
                passwordChangeDto.getCurrentPassword(),
                passwordChangeDto.getNewPassword()
        );

        if (isPasswordChanged) {
            return ResponseEntity.ok("Password changed successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid OTP or mobile number");
        }
    }


    @GetMapping("/username")
    public ResponseEntity<User> getUserByUsername(@RequestParam("username") String username) {
        Optional<User> userInfo = userAccountService.getUserByUsername(username);

        return userInfo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

}
