package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views")
public class ViewController {

	
	@RequestMapping("/login")
	public String getLogin()
	{
		return "login";
	}
	
	@RequestMapping("/register")
	public String getRegister()
	{
		return "register";
	}
	
	@RequestMapping("/labdash")
	public String getLabDash()
	{
		return "labdash";
	}
	
}
