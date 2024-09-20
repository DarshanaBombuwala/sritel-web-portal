package com.sritel.service_subscription_service.service;

import com.sritel.service_subscription_service.enums.SubscriptionStatus;
import com.sritel.service_subscription_service.model.ServiceSubscription;
import com.sritel.service_subscription_service.repository.ServiceSubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ServiceSubscriptionService {

    private final ServiceSubscriptionRepository serviceSubscriptionRepository;


    public void activateService(Long userId, Long serviceId) {
        // Fetch user details from user-service using Feign Client

        // Now you have user details, continue with your service subscription logic
        // Example: Activate service for the user
        ServiceSubscription subscription = new ServiceSubscription();
        subscription.setUserId(userId);  // Use userId from the fetched user details
        subscription.setServiceId(serviceId);
        subscription.setStatus(SubscriptionStatus.valueOf("ACTIVE"));
        subscription.setActivationDate(LocalDateTime.now());

        serviceSubscriptionRepository.save(subscription);
    }

    public void deactivateService(Long userId, Long serviceId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        ServiceSubscription subscription = serviceSubscriptionRepository
                .findByUserAndService(user, service)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));

        subscription.setStatus(SubscriptionStatus.valueOf("INACTIVE"));
        subscription.setDeactivationDate(LocalDateTime.now());

        serviceSubscriptionRepository.save(subscription);
    }
}
