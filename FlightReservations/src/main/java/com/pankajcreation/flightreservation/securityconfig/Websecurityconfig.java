package com.pankajcreation.flightreservation.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class Websecurityconfig extends WebSecurityConfigurerAdapter {

	
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		
		return new BCryptPasswordEncoder();
		
	}
	
	
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
	 	
	
			http.authorizeRequests().antMatchers("/showreg" ,"/", "/index.html" , "/registration", "/login", "/showlogin","/login/*","/reservations/*","flights").permitAll()
									//anybody can acccess
			.antMatchers("/admin/*").hasAnyAuthority("ADMIN").anyRequest().authenticated().and().csrf().disable();
																					
	}
	
	@Bean(name=BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
}
