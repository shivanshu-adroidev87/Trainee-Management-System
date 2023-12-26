package com.nucleus.project.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:securityConfig.properties")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${admin.role}")
    private String adminRole;

    @Value("${trainee.role}")
    private String traineeRole;

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;


    @Value("${trainee1.username}")
    private String trainee1Username;

    @Value("${trainee1.password}")
    private String trainee1Password;

//    @Value("${trainee2.username}")
//    private String trainee2Username;
//
//    @Value("${trainee2.password}")
//    private String trainee2Password;
//
//    @Value("${trainee3.username}")
//    private String trainee3Username;
//
//    @Value("${trainee3.password}")
//    private String trainee3Password;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/login").authenticated()
                .antMatchers("/adminLogin/**").hasRole(adminRole)
                .antMatchers("/traineeLogin/**").hasRole(traineeRole)
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username(adminUsername)
                .password(adminPassword)
                .roles(adminRole)
                .build();

        UserDetails user2 = User.builder()
                .username(trainee1Username)
                .password(trainee1Password)
                .roles(traineeRole)
                .build();

//        UserDetails user3 = User.builder()
//                .username(trainee2Username)
//                .password(trainee2Password)
//                .roles(traineeRole)
//                .build();
//
//        UserDetails user4 = User.builder()
//                .username(trainee3Username)
//                .password(trainee3Password)
//                .roles(traineeRole)
//                .build();



        return new InMemoryUserDetailsManager(user1, user2);
    }
}
