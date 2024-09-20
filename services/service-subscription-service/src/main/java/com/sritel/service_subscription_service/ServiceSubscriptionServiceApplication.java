package com.sritel.service_subscription_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceSubscriptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceSubscriptionServiceApplication.class, args);
	}

}
