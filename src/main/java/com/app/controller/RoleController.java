package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Role;
import com.app.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService service;
	
	@PostMapping("/saverole")
	public ResponseEntity<String> save(@RequestBody Role role) {
		// TODO Auto-generated method stub
		return new ResponseEntity<String>(service.save(role),HttpStatus.OK);
	}
}
