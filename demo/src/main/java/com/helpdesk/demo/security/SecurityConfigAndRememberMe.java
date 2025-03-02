// package com.helpdesk.demo.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.factory.PasswordEncoderFactories;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
// import org.springframework.beans.factory.annotation.Qualifier;
// import static org.springframework.security.config.Customizer.withDefaults;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfigAndRememberMe {

//     @Bean
//     SecurityFilterChain securityFilterChain(HttpSecurity http, 
//         @Qualifier("mongoPersistentTokenService") PersistentTokenRepository tokenRepository) throws Exception {
//             http
//                 .authorizeHttpRequests((authorize) -> authorize
//                 .anyRequest().authenticated())
//                 .formLogin(withDefaults())
//                 .rememberMe((remember) -> remember
//                 .tokenRepository(tokenRepository)
//                 .rememberMeParameter("remember-me")
//                 .key("clave-secreta-segura")            
//                 .tokenValiditySeconds(604800)); 

//         return http.build();
//     }

//     @Bean
//     public UserDetailsService userDetailsService() {
//         UserDetails userDetails = User.builder()
//             .username("user")
//             .password(passwordEncoder().encode("password"))
//             .roles("USER")
//             .build();

//         return new InMemoryUserDetailsManager(userDetails);
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//     }
// }
