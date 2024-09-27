package com.sritel.service_subscription_service.service;

import com.sritel.service_subscription_service.enums.SubscriptionStatus;
import com.sritel.service_subscription_service.model.ServiceSubscription;
import com.sritel.service_subscription_service.repository.ServiceSubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceSubscriptionService {

    private final ServiceSubscriptionRepository serviceSubscriptionRepository;
    private final JwtService jwtService;


    public void activateService(int userId, Long serviceId) {
        // Fetch user details from user-service using Feign Client

        // Now you have user details, continue with your service subscription logic
        // Example: Activate service for the user
        ServiceSubscription subscription = new ServiceSubscription();
        subscription.setUserId((long) userId);  // Use userId from the fetched user details
        subscription.setServiceId(serviceId);
        subscription.setStatus(SubscriptionStatus.valueOf("ACTIVE"));
        subscription.setActivationDate(LocalDateTime.now());

        serviceSubscriptionRepository.save(subscription);
    }

    public void deactivateService(int userId, int serviceId){
        ServiceSubscription subscription = serviceSubscriptionRepository
                .findByUserAndService(userId, serviceId);
        if(subscription != null) {
            subscription.setStatus(SubscriptionStatus.valueOf("INACTIVE"));
            subscription.setDeactivationDate(LocalDateTime.now());

            serviceSubscriptionRepository.save(subscription);
        }
    }

    public List<Integer> getAllSubscribedServices(){
        return serviceSubscriptionRepository.findAllSubscribedServicesByUserId(jwtService.extractUserId());
    }
}
