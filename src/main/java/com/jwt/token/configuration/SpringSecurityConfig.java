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

		UserDetails irix = org.springframework.security.core.userdetails.User.builder()
				.username("irix")
				.password(passwordEncoder().encode("irix"))
				.roles("IRIX")
				.build();

		UserDetails bankMfiuser = org.springframework.security.core.userdetails.User.builder()
				.username("bank/mfiuser")
				.password(passwordEncoder().encode("bank/mfiuser"))
				.roles("BANK/MFIUSER")
				.build();

		UserDetails businesscorrespondent = org.springframework.security.core.userdetails.User.builder()
				.username("businesscorrespondent")
				.password(passwordEncoder().encode("businesscorrespondent"))
				.roles("BUSINESSCORRESPONDENT")
				.build();

		return new InMemoryUserDetailsManager(irix, bankMfiuser, businesscorrespondent);
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {

		return configuration.getAuthenticationManager();

	}

}