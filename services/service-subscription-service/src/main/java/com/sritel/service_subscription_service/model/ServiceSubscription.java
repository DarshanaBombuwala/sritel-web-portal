package com.sritel.service_subscription_service.model;

import com.sritel.service_subscription_service.enums.SubscriptionStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "service_subscriptions")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class ServiceSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;  // This comes from the user-service

    @Column(nullable = false)
    private Long serviceId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SubscriptionStatus status;

    private LocalDateTime activationDate;
    private LocalDateTime deactivationDate;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
}

