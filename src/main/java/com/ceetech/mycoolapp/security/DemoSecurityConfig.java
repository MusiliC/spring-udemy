// package com.ceetech.mycoolapp.security;

// import javax.sql.DataSource;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.provisioning.JdbcUserDetailsManager;
// import org.springframework.security.provisioning.UserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class DemoSecurityConfig {

//         // add support for jdbc

//         @Bean
//         public UserDetailsManager userDetailsManager(DataSource dataSource) {

//                 JdbcUserDetailsManager jUserDetailsManager = new JdbcUserDetailsManager(dataSource);

//                 // define query to retrieve user by username

//                 jUserDetailsManager
//                                 .setUsersByUsernameQuery("select user_id, pw, active from members where user_id = ?");

//                 // define query to retrieve roles by username
//                 jUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id = ?");

//                 return jUserDetailsManager;
//         }

//         @Bean
//         public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//                 http.authorizeHttpRequests(config -> config
//                                 .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
//                                 .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
//                                 .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
//                                 .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
//                                 .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN"));

//                 // http Basic Authentication
//                 http.httpBasic(Customizer.withDefaults());

//                 // disable CSRF
//                 http.csrf(csrf -> csrf.disable());

//                 return http.build();
//         }

// }

// // @Bean
// // public InMemoryUserDetailsManager userDetailsManager() {

// // // UserDetails john = User.builder()
// // // .username("John")
// // // .password("{noop}1234")
// // // .roles("EMPLOYEE")
// // // .build();

// // // UserDetails mary = User.builder()
// // // .username("mary")
// // // .password("{noop}1234")
// // // .roles("EMPLOYEE", "MANAGER")
// // // .build();

// // // UserDetails susan = User.builder()
// // // .username("susan")
// // // .password("{noop}1234")
// // // .roles("EMPLOYEE", "MANAGER", "ADMIN")
// // // .build();

// // return new InMemoryUserDetailsManager(john, mary, susan);

// // }