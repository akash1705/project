package com.app.service;

import java.util.List;

import com.app.entity.Hospital;

public interface HospitalService {
	
	public String register(Hospital user);
	public Integer authenticate(String email,String password);
	public List<Hospital> getAllHospitals();
}
