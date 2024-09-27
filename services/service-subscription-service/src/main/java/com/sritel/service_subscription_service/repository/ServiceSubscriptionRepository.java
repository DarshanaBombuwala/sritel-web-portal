package com.sritel.service_subscription_service.repository;

import com.sritel.service_subscription_service.model.ServiceSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceSubscriptionRepository extends JpaRepository<ServiceSubscription,Long> {

    @Query("SELECT ss FROM ServiceSubscription ss WHERE ss.userId = :userId AND ss.serviceId = :serviceId")
    ServiceSubscription findByUserAndService(@Param("userId") int userId, @Param("serviceId") int serviceId);

    @Query("SELECT ss.serviceId FROM ServiceSubscription ss WHERE ss.userId = :userId")
    List<Integer> findAllSubscribedServicesByUserId(@Param("userId") int userId);
}
