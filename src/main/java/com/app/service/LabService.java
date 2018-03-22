package com.app.service;

import com.app.entity.Lab;

public interface LabService {
	
	public String register(Lab user);
	public Integer authenticate(String email,String password);
	
	public Integer logOut(String email);

}
