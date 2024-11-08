package com.sritel.service_subscription_service.controller;

import com.sritel.service_subscription_service.service.JwtService;
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
    private final JwtService jwtService;

    @PostMapping("/activate/{serviceId}")
    public ResponseEntity<String> activateService(@PathVariable("serviceId") int serviceId) {
        try{
            serviceSubscriptionService.activateService(jwtService.extractUserId(), serviceId);
            System.out.println(jwtService.extractUserId());
            return ResponseEntity.ok("Service activated successfully");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/deactivate/{serviceId}")
    public ResponseEntity<String> deactivateService(@PathVariable("serviceId") int serviceId) {
        serviceSubscriptionService.deactivateService(jwtService.extractUserId(), serviceId);
        return ResponseEntity.ok("Service deactivated successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getAllSubscribedServices() {
        return ResponseEntity.ok(serviceSubscriptionService.getAllSubscribedServices());
    }


}
