package com.sritel.service_subscription_service.service;

import com.sritel.service_subscription_service.feignclient.UserDataClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserDataClient userDataClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserDetails> userDetail = userDataClient.getUserDetails(username); // Assuming 'email' is used as username

        // Converting UserInfo to UserDetails
        return userDetail.orElseThrow();

    }
}
