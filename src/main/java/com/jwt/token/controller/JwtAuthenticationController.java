package com.jwt.token.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class JwtAuthenticationController {

	private UserDetailsService userDetailsService;

	private AuthenticationManager manager;

	private com.jwt.token.helper.JwtHelper helper;

	@PostMapping("/authenticate")
	public ResponseEntity<com.jwt.token.model.JwtResponse> login(@RequestBody com.jwt.token.model.JwtRequest request) {
		// authenticate
		this.doAuthenticate(request.getUsername(), request.getPassword());

		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		String token = this.helper.generateToken(userDetails);

		com.jwt.token.model.JwtResponse response = com.jwt.token.model.JwtResponse.builder()
				.jwtToken(token)
				.username(userDetails
				.getUsername())
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private void doAuthenticate(String username, String password) {
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,
				password);
		try {
			manager.authenticate(authentication);
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Credentials Invalid !!");
		}

	}
}