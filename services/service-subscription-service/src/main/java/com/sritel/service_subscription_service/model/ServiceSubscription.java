package com.sritel.service_subscription_service.model;

import com.sritel.service_subscription_service.enums.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "service_subscriptions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime activationDate;

    private LocalDateTime deactivationDate;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private Long serviceId;

    private String serviceName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubscriptionStatus status;

    @Column(nullable = false)
    private Long userId;  // This comes from the user-service


    // Getters and Setters
}

