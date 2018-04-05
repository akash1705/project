package com.app.service;

import java.util.Arrays;
import java.util.HashSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Lab;
import com.app.entity.Role;
import com.app.repositories.LabRepository;
import com.app.repositories.RoleRepository;

@Service
@Transactional
public class LabServiceImpl implements LabService {
	
	@Autowired
	private LabRepository repo;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public String register(Lab user) {
		// TODO Auto-generated method stub
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Role role=roleRepo.findByRole("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(role)));
		return repo.saveAndFlush(user).getEmail();
	}

	@Override
	public Integer authenticate(String email, String password) {
		// TODO Auto-generated method stub
		Lab dbCopy=repo.findByEmail(email);
		if(null==dbCopy)
			return 9; //User doesn't exit
		
		if(dbCopy.getPassword().equals(password))
		{
			session.setAttribute("loggedInMember", dbCopy.getEmail());
			return 0;//Authentication successful
		}
		else
		return 1;//Password incorrect
	}

	@Override
	public Integer logOut(String email) {
		// TODO Auto-generated method stub
		
		/*if(session.getAttribute("loggedInMember"))
		session.removeValue(email);
		return 0;
*/
		return 0;
	}

}
