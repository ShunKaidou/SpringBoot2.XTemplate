package com.wecp.w3day5task1.config;

import com.wecp.w3day5task1.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                        .withUser("user").password(passwordEncoder().encode("user123")).roles("USER")
                        .and()
                        .withUser("admin").password(passwordEncoder().encode("admin123")).roles("ADMIN");

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
            .authorizeRequests()
        .antMatchers("/admin").hasRole("ADMIN")
        .anyRequest().authenticated()
            .and()
            .httpBasic()
            .and()
            .csrf().disable();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    // extends WebSecurityConfigurerAdapter.

    // Override the configure(HttpSecurity http) method to define the security rules.
    // Configure HTTP Basic authentication.
    // Configure in-memory authentication with at least two users (one with USER role and another with ADMIN role).
}
