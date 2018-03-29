package com.app.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views")
public class ViewController implements ErrorController {

	
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

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	
}
