package com.adminportal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.adminportal.domain.User;
import com.adminportal.repository.MemRepository;

@Service
public class UserSecurityService implements UserDetailsService{
	
	@Autowired
	private MemRepository memRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = memRepository.findByUsername(username);
		
		if(null == user) {
			throw new UsernameNotFoundException("找不到使用者帳號");
		}
		
		return user;
	}

}
