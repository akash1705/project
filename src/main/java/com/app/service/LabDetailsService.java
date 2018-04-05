package com.app.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.app.entity.Lab;
import com.app.entity.Role;
import com.app.repositories.LabRepository;

@Service
@Transactional
public class LabDetailsService implements UserDetailsService {

	@Autowired
	private LabRepository repo;
	
	private static final Logger logger=Logger.getLogger(LabDetailsService.class);
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Lab lab=repo.findByEmail(arg0);
		logger.info(lab);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : lab.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
		UserDetails user=(UserDetails)new User(lab.getEmail(), lab.getPassword(), grantedAuthorities);
		logger.info(user);
		return user;
	}

}
