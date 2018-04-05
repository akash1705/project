package com.app.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/views")
public class ViewController implements ErrorController {

	
	@RequestMapping("/hosplogin")
	public String getHospLogin()
	{
		return "hosplogin";
	}
	
	@RequestMapping(value = "/lablogin", method = RequestMethod.GET)
	public String getLabLogin()
	{
		return "lablogin";
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
