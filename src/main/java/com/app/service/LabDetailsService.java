package com.app.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
public class LabDetailsService implements UserDetailsService {

	@Autowired
	private LabRepository repo;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Lab lab=repo.findByEmail(arg0);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : lab.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
		
		return new org.springframework.security.core.userdetails.User(lab.getEmail(), lab.getPassword(), grantedAuthorities);
	}

}
