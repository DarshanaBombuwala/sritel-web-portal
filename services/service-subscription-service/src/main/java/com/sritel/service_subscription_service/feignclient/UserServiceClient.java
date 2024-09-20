package com.sritel.service_subscription_service.feignclient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-service")
public class UserServiceClient {

}
