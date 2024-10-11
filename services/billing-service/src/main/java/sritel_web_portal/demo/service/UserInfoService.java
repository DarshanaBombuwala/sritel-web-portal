package sritel_web_portal.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sritel_web_portal.demo.dto.UserDto;
import sritel_web_portal.demo.feignclient.UserDataClient;

import java.util.Optional;

@Service
//@RequiredArgsConstructor
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
        return new UserInfoDetails(userDto.getUserName(), userDto.getPassword(), userDto.getRoles(), userDto.getUserId());

    }
}
