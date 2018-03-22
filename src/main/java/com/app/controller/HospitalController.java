package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Hospital;
import com.app.service.HospitalService;

@RestController
//@RequestMapping("/user")
@RequestMapping("/hospital")
public class HospitalController {
	
	@Autowired
	private HospitalService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Hospital user)
	{
		
		return new ResponseEntity<String>(service.register(user), HttpStatus.OK);
	}
	
	@PostMapping("/auth")
	public ResponseEntity<Integer> authenticate(@RequestBody Hospital user)
	{
		return new ResponseEntity<Integer>(service.authenticate(user.getEmail(),user.getPassword()), HttpStatus.OK);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Hospital>> getAllHospitals()
	{
		return new ResponseEntity<List<Hospital>>(service.getAllHospitals(),HttpStatus.OK);
	}

	
}
