package com.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Maincontroller {

	@RequestMapping("/home")
	public String test()
	{
		System.out.println("this is home page");
		return "home";
		
	}
	
	
	
}
