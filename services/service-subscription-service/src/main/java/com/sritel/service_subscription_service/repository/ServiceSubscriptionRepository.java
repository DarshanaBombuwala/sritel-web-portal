package com.sritel.service_subscription_service.repository;

import com.sritel.service_subscription_service.model.ServiceSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceSubscriptionRepository extends JpaRepository<ServiceSubscription,Long> {
}
