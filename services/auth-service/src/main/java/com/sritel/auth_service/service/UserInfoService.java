package com.sritel.auth_service.service;

import com.sritel.auth_service.dto.UserDto;
import com.sritel.auth_service.feignclient.UserDataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserDataClient userDataClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserDto> userDetail = userDataClient.getUserByUsername(username); // Assuming 'email' is used as username

        if(userDetail.isEmpty()) {
            return null;
        }

        UserDto userDto = userDetail.get();
        System.out.println(userDto);
        return new UserInfoDetails(userDto.getUserName(), userDto.getPassword(), userDto.getRoles(), userDto.getUserId());
    }
}