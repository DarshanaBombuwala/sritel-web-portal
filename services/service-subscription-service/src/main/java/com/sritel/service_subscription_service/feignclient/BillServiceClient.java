package com.sritel.service_subscription_service.feignclient;

import com.sritel.service_subscription_service.config.FeignClientConfig;
import com.sritel.service_subscription_service.dto.BillDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "BILL-SERVICE", configuration = FeignClientConfig.class)
public interface BillServiceClient {

    @PostMapping("/bill/create")
    Boolean createBill(@RequestBody BillDto billDto);
}
