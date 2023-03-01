package com.pankajcreation.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pankajcreation.flightreservation.entities.User;
import com.pankajcreation.flightreservation.repos.Userrepository;
import com.pankajcreation.flightreservation.services.Securityservice;


@Controller
public class Usercontroller {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private Securityservice security;
	
	
	private static final Logger logger = LoggerFactory.getLogger(Usercontroller.class) ;

	
	/*
	
1. Logging in Spring Boot refers to the process of recording information 
about the application's execution, such as warnings, errors, and debugging 
information, into log files. 
This information can be useful for troubleshooting issues and monitoring
application performance.

2. Spring Boot uses a logging framework called Logback by default, 
which provides a flexible and configurable logging system. 
	
	*/
	
	@Autowired
	private Userrepository userrepository;
	
	@RequestMapping("/showreg")
	public String showregistration()
	{
		logger.info("this is inside of this method -> showregistration()");
		return "registration";
	}
	
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user)
	{
		logger.info("this is inside of this method and user ->  register()"+user);
		
		
		user.setPassword(encoder.encode(user.getPassword()));
		
		this.userrepository.save(user);
		
		
		
		return "login";
	}
	
	@RequestMapping("/showlogin")
	public String showrelogin()
	{
		logger.info("this is inside of this method ->  showrelogin()");
		
		return "login";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginuser(@RequestParam("emaill") String emaill, @RequestParam("password")  String password, ModelMap map)
	{
		logger.info("this is inside of this method and email ->  loginuser()"+emaill);
		/*
		logger.error("error");
		logger.warn("warn");
		logger.info("info"); // by default it is info
		logger.debug("debug"); // it will not show up
		logger.trace("trace");// it will not show up
		*/
	
		boolean loginres = this.security.login(emaill, password);
		
		if (loginres==true)
		{
			return "findflight"; // session
		}
		else if(loginres==false) 
		{
		map.addAttribute("msg", "something went wrong , your email or password is wrong, please try again");
		return "login";
		}
		return "login";
	}
	
}
