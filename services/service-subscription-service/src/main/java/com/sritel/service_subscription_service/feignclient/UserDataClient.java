package com.sritel.service_subscription_service.feignclient;

import com.sritel.service_subscription_service.config.FeignClientConfig;
import com.sritel.service_subscription_service.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "USER-SERVICE", configuration = FeignClientConfig.class)
public interface UserDataClient {
    @GetMapping("/account/username")
    Optional<UserDto> getUserByUsername(@RequestParam("username") String username);
}
