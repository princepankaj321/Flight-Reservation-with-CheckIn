package com.pankajcreation.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class Securityserviceimple implements Securityservice {

	@Autowired
	private UserDetailsService service;
	
	@Autowired
	private AuthenticationManager manager;

	@Override
	public boolean login(String username, String password) {

		UserDetails userDetails = service.loadUserByUsername(username);

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password,
				userDetails.getAuthorities());

		try {
			manager.authenticate(token);

			boolean authenticated = token.isAuthenticated();

			if (authenticated == true) {
				SecurityContextHolder.getContext().setAuthentication(token);
			}

			return authenticated;
		} catch (AuthenticationException e) {
			SecurityContextHolder.clearContext();
			return false;
		}

	}

}

