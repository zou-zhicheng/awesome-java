package tacocloud.entity;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 注册页面的实体类
 * 
 * @author insight 
 * @since 2021/5/9
 */
@Data
public class RegisterForm {
    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(
                username, passwordEncoder.encode(password),
                fullname, street, city, state, zip, phone);
    }
}