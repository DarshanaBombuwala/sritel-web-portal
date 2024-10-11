package sritel_web_portal.demo.service;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserInfoDetails implements UserDetails {

    private final String username; // Changed from 'name' to 'username' for clarity
    private final String password;
    private final List<GrantedAuthority> authorities;
    @Getter
    private final int userId;

    public UserInfoDetails(String username, String password, String roles, int userId) {
        this.username = username; // Assuming 'name' is used as 'username'
        this.password = password;
        this.authorities = List.of(new SimpleGrantedAuthority("ROLE_"+roles));
        this.userId = userId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implement your logic if you need this
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement your logic if you need this
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement your logic if you need this
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement your logic if you need this
    }
}

