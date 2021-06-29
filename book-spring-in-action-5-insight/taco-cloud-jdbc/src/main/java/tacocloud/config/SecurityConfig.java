package tacocloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * Spring Security 的Java显示配置 覆盖掉自动配置
 * <p>
 * 基于 JDBC 的用户存储
 *
 * @author insight
 * @since 2021/5/9
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource =
                dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*
         * 由于 Spring Security 查找用户的sql语句可能与我们的数据库不符
         * 所以可以重写 sql 语句, 这里重写认证和权限
         */
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled " +
                        "from Users " +
                        "where username = ?")
                .authoritiesByUsernameQuery("select username, authority from " +
                        "Authorities where username = ?")
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