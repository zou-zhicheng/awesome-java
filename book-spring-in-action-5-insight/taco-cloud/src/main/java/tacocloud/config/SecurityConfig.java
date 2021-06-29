package tacocloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Spring Security 的Java显示配置 覆盖掉自动配置
 *
 * 基于内存的用户存储
 *
 * @author insight
 * @since 2021/5/9
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*
         * builder 设计模式
         * Spring Security 5.0 以上的默认密码存储格式为
         * {id}encodepassword id 是加密方式
         * 如果不知道加密方式 There is no PasswordEncoder mapped for the id "null"
         * 这里使用 bcrypt
         */
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("jin")
                .password(new BCryptPasswordEncoder().encode("champool"))
                .roles("USER")
                .and()
                .withUser("spike")
                .password(new BCryptPasswordEncoder().encode("spacecowboy"))
                .roles("USER");
    }
}