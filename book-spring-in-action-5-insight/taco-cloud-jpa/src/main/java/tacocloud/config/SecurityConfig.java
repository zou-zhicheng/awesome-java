package tacocloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * Spring Security 的Java显示配置 覆盖掉自动配置
 *
 * @author insight
 * @since 2021/5/9
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserDetailsService userDetailsService;
    private DataSource dataSource;

    @Autowired
    public void setUserDetailsService(@Qualifier("userRepositoryUserServiceImpl") UserDetailsService userDetailsService) { this.userDetailsService = userDetailsService; }

    @Autowired
    public void setDataSource(DataSource dataSource) { this.dataSource =
            dataSource; }

    /**
     * 添加用户详情服务
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(bcryptEncoder());
    }

    /**
     * 配置可访问页面的用户
     * 配置登录路径
     * 配置注销后的页面
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/design", "/orders")
                    .hasRole("USER")
                .antMatchers("/", "/**")
                    .permitAll()
                .and()
                .formLogin()
                    .loginPage("/login")
                .and()
                .logout()
                    .logoutSuccessUrl("/");
        // remember-me
        http.rememberMe()
                .tokenRepository(tokenRepository())
                .tokenValiditySeconds(86400);

        // 取消对数据库控制台的csrf保护 连接数据库
        http.csrf().ignoringAntMatchers("/h2-console/**");
        // 允许同源使用 iframe 显示数据库
        http.headers().frameOptions().sameOrigin();
    }

    /**
     * encoder 使用 @Bean, 单例, 不浪费资源
     */
    @Bean
    public PasswordEncoder bcryptEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository tokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository =
                new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
        tokenRepository.setCreateTableOnStartup(true);

        return tokenRepository;
    }
}