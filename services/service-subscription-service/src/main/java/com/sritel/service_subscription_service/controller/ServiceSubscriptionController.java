package com.sritel.service_subscription_service.controller;

import com.sritel.service_subscription_service.service.JwtService;
import com.sritel.service_subscription_service.service.ServiceSubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/subscription")
@RequiredArgsConstructor
public class ServiceSubscriptionController {

    private final ServiceSubscriptionService serviceSubscriptionService;
    private final JwtService jwtService;

    @PostMapping("/activate/{serviceId}")
    public ResponseEntity<String> activateService(@PathVariable("serviceId") int serviceId) {
        try{
            if(!serviceSubscriptionService.activateService(jwtService.extractUserId(), serviceId)) throw new Exception();

            return ResponseEntity.ok("Service activated successfully");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/deactivate/{serviceId}")
    public ResponseEntity<String> deactivateService(@PathVariable("serviceId") int serviceId) {
        try{
            if(!serviceSubscriptionService.deactivateService(jwtService.extractUserId(), serviceId))
                throw new Exception();

            return ResponseEntity.ok("Service deactivated successfully");
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getAllSubscribedServices() {
        return ResponseEntity.ok(serviceSubscriptionService.getAllSubscribedServices());
    }


}
