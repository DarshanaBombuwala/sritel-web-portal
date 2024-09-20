package com.sritel.service_subscription_service.controller;

import com.sritel.service_subscription_service.service.ServiceSubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/subscription")
@RequiredArgsConstructor
public class ServiceSubscriptionController {

    private final ServiceSubscriptionService serviceSubscriptionService;

    @PostMapping("/activate")
    public ResponseEntity<String> activateService(@RequestParam Long userId, @RequestParam Long serviceId) {
        serviceSubscriptionService.activateService(userId, serviceId);
        return ResponseEntity.ok("Service activated successfully");
    }

    @PostMapping("/deactivate")
    public ResponseEntity<String> deactivateService(@RequestParam Long userId, @RequestParam Long serviceId) {
        serviceSubscriptionService.deactivateService(userId, serviceId);
        return ResponseEntity.ok("Service deactivated successfully");
    }


}
