package com.pankajcreation.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pankajcreation.flightreservation.entities.User;
import com.pankajcreation.flightreservation.repos.Userrepository;

@Service
public class Userdetailserviceimple implements UserDetailsService {

	
	@Autowired
	private Userrepository userrepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		User emaill = this.userrepository.findByEmaill(username);
		
		if (emaill==null) {
			
			throw new UsernameNotFoundException("User is not found for this email"+username);
			
		}
		
		
		return new org.springframework.security.core.userdetails.User(emaill.getEmaill(),emaill.getPassword(),emaill.getRoles());
	}

}
