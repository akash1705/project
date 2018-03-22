package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.entity.Lab;
import com.app.service.LabService;

@RestController
@RequestMapping("/lab")
public class LabController {

	@Autowired
	private LabService service;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> addLab(@RequestBody Lab user)
	{
		
		return new ResponseEntity<String>(service.register(user), HttpStatus.OK);
	}
	
	@PostMapping("/auth")
	public ResponseEntity<Integer> authenticate(@RequestBody Lab user)
	{
		return new ResponseEntity<Integer>(service.authenticate(user.getEmail(), user.getPassword()), HttpStatus.OK);
	}
	
	@GetMapping("/logout/{email}")
	public Integer logOut(@PathVariable String email)
	{
		return 0;
	}
	
	
	
	
}
