package com.sritel.service_subscription_service.service;

import com.sritel.service_subscription_service.dto.BillDto;
import com.sritel.service_subscription_service.enums.BillStatus;
import com.sritel.service_subscription_service.enums.SubscriptionStatus;
import com.sritel.service_subscription_service.feignclient.BillServiceClient;
import com.sritel.service_subscription_service.model.ServiceSubscription;
import com.sritel.service_subscription_service.repository.ServiceRepository;
import com.sritel.service_subscription_service.repository.ServiceSubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceSubscriptionService {

    private final ServiceSubscriptionRepository serviceSubscriptionRepository;
    private final JwtService jwtService;
    private final BillServiceClient billServiceClient;
    private final ServiceRepository serviceRepository;


    public void activateService(int userId, int serviceId) {
        // Fetch user details from user-service using Feign Client
        Optional<com.sritel.service_subscription_service.model.Service> service = serviceRepository.findById((long) serviceId);
        // Now you have user details, continue with your service subscription logic
        // Example: Activate service for the user
        if(service.isPresent()) {
            com.sritel.service_subscription_service.model.Service service1 = service.get();

            ServiceSubscription subscription = new ServiceSubscription();
            subscription.setUserId((long) userId);  // Use userId from the fetched user details
            subscription.setServiceId((long) serviceId);
            subscription.setStatus(SubscriptionStatus.valueOf("ACTIVE"));
            subscription.setServiceName(service1.getName());
            subscription.setActivationDate(LocalDateTime.now());
            serviceSubscriptionRepository.save(subscription);

            String result = billServiceClient.createBill(
                new BillDto(
                    0,
                    service1.getAmount(),
                    BillStatus.PENDING,
                    userId,
                    service1.getName(),
                    serviceId
                )
            );
        }
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
