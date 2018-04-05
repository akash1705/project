package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Role;
import com.app.repositories.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository repo;
	
	@Override
	public String save(Role role) {
		// TODO Auto-generated method stub
		return repo.saveAndFlush(role).getRole();
	}

}
