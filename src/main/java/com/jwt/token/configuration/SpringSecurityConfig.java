package com.jwt.token.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	UserDetailsService userDetailsService() {

		

		UserDetails userAdmin = org.springframework.security.core.userdetails.User.builder()
				.username("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("admin")
				.build();

		UserDetails user = org.springframework.security.core.userdetails.User.builder()
				.username("user")
				.password(passwordEncoder().encode("user"))
				.roles("user")
				.build();

		UserDetails userBusiness = org.springframework.security.core.userdetails.User.builder()
				.username("userBusiness")
				.password(passwordEncoder().encode("userBusiness"))
				.roles("userBusiness")
				.build();

		return new InMemoryUserDetailsManager(userAdmin, user, userBusiness);
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {

		return configuration.getAuthenticationManager();

	}

}
