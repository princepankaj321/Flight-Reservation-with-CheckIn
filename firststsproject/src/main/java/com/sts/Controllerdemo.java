package com.sts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controllerdemo {

	
	@RequestMapping("/home")
	@ResponseBody
	public String controllertesting()
	{
		
		return "this is returning string without jsp";
	}
	
	
}
