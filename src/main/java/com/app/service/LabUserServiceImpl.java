package com.app.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.entity.Lab;
import com.app.repositories.LabRepository;
import com.app.repositories.RoleRepository;

@Service
public class LabUserServiceImpl {

	@Autowired
    private LabRepository labRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //@Override
    public void save(Lab user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        labRepository.save(user);
    }

    //@Override
    public Lab findByUsername(String username) {
        return labRepository.findByEmail(username);
    }
	
	
	
	
}
