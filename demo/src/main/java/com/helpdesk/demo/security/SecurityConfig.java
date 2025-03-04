package com.helpdesk.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
				.requestMatchers(
					"/", 
                    "/swagger-ui/**", 
                    "/swagger-resources/**",
                    "/v2/api-docs",
                    "/v3/api-docs",
                    "/configuration/ui",
                    "/configuration/security"
					).permitAll()
				.anyRequest().authenticated()
			)
			.oauth2Login(Customizer.withDefaults());

		return http.build();
	}
}

