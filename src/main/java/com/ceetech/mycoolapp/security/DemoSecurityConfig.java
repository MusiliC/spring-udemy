package com.ceetech.mycoolapp.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                .username("John")
                .password("{noop}1234")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}1234")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}1234")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);

    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(config ->
                        config
                                .requestMatchers("/").hasAnyRole("EMPLOYEE")
                                .requestMatchers("/leaders/**").hasAnyRole("MANAGER", "ADMIN")
                                .requestMatchers("/system/**").hasAnyRole("ADMIN")
                                .anyRequest().authenticated())
                .exceptionHandling(config ->
                        config.accessDeniedPage("/not-found")
                )

                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                );


        return http.build();
    }

}


//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//
//        JdbcUserDetailsManager jUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//
//        // define query to retrieve user by username
//
//        jUserDetailsManager
//                .setUsersByUsernameQuery("select user_id, pw, active from members where user_id = ?");
//
//        // define query to retrieve roles by username
//        jUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id = ?");
//
//        return jUserDetailsManager;
//    }