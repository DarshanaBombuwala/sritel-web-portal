package com.sritel.service_subscription_service.repository;

import com.sritel.service_subscription_service.model.ServiceSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ServiceSubscriptionRepository extends JpaRepository<ServiceSubscription,Long> {

    @Transactional(readOnly = true)
    @Query(value = "SELECT ss FROM ServiceSubscription ss WHERE ss.userId = :userId AND ss.serviceId = :serviceId")
    ServiceSubscription findByUserAndService(@Param("userId") int userId, @Param("serviceId") int serviceId);

    @Transactional(readOnly = true)
    @Query("SELECT ss.serviceId FROM ServiceSubscription ss WHERE ss.userId = :userId AND ss.status = 'ACTIVE'")
    List<Integer> findAllSubscribedServicesByUserId(@Param("userId") int userId);

//    ServiceSubscription findFirstByUserIdAndServiceId(Long userId, Long serviceId);

}
