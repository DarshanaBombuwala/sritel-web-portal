package sritel_web_portal.demo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "user-service")
public interface UserDataClient {
    @GetMapping("/user/user-details")
    Optional<UserDetails> getUserDetails(@RequestParam("username") String username);
}
