package sritel_web_portal.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int userId;
    private String firstName;
    private String lastname;
    private String userName;
    private String password;
    private String email;
    private Integer mobileNumber;
    private String roles;
}
