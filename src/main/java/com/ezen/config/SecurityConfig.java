package com.ezen.config;

import com.ezen.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration // 설정 파일
@EnableWebSecurity // 시큐리티 활성화
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private UserDetailsService userDetails;

    @SuppressWarnings("deprecation")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().requestMatchers("/").permitAll();
        httpSecurity.authorizeRequests().requestMatchers("/member/**").hasAnyRole("ADMIN","MEMBER");
        httpSecurity.authorizeRequests().requestMatchers("/admin/**").hasRole("ADMIN");

        httpSecurity.csrf().disable();
        httpSecurity.formLogin().loginPage("/login");
        httpSecurity.exceptionHandling().accessDeniedPage("/accessDenied");
        httpSecurity.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");

        httpSecurity.userDetailsService(userDetails);
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
