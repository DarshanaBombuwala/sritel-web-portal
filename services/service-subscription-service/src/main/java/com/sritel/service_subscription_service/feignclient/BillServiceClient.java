package com.sritel.service_subscription_service.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "BILL-SERVICE")
public interface BillServiceClient {

    @PostMapping("/bill/create")
    void getUserByUsername(@RequestParam("username") String username);
}
