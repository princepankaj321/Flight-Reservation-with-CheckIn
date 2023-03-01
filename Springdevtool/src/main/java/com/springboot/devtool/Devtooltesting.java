package com.springboot.devtool;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Devtooltesting {

	@RequestMapping("/home")
	@ResponseBody
	public String test()
	{
		int a = 46;
		int b = 35;
		
		return "addition" +a+b;
	}
	
}
