package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Hospital;

import com.app.repositories.HospitalRepository;



@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {

	
	@Autowired
	private HospitalRepository repo;
	
	@Override
	public String register(Hospital user) {
		// TODO Auto-generated method stub
		return repo.saveAndFlush(user).getEmail();
	}

	@Override
	public Integer authenticate(String email, String password) {
		// TODO Auto-generated method stub
		Hospital dbCopy=repo.findByEmail(email);
		if(null==dbCopy)
			return 9; //User doesn't exit
		
		if(dbCopy.getPassword().equals(password))
		{
			return 0;//Authentication successful
		}
		else
		return 1;//Password incorrect
	}

	@Override
	public List<Hospital> getAllHospitals() {
		// TODO Auto-generated method stub
		
		
		return repo.findAll();
	}

}


