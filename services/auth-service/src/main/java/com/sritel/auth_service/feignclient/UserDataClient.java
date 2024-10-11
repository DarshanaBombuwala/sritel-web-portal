package com.sritel.auth_service.feignclient;

import com.sritel.auth_service.dto.UserDto;
import com.sritel.auth_service.model.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "USER-SERVICE")
public interface UserDataClient {
    @GetMapping("/account/username")
    Optional<UserDto> getUserByUsername(@RequestParam("username") String username);
}
