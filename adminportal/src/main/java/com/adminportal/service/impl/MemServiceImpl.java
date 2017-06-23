package com.adminportal.service.impl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal.domain.User;
import com.adminportal.domain.security.UserRole;
import com.adminportal.repository.RoleRepository;
import com.adminportal.repository.MemRepository;
import com.adminportal.service.MemService;

@Service
public class MemServiceImpl implements MemService {

	private static final Logger LOG = LoggerFactory.getLogger(MemService.class);
	
	@Autowired
	private MemRepository memRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRoles) {
		User localUser = memRepository.findByUsername(user.getUsername());

		if (localUser != null) {
			LOG.info("使用者 {} 已存在，沒有改動任何東西", user.getUsername());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}

			user.getUserRoles().addAll(userRoles);

			localUser = memRepository.save(user);
		}

		return localUser;
	}

	@Override
	public User save(User user) {
		return memRepository.save(user);
	}

}
