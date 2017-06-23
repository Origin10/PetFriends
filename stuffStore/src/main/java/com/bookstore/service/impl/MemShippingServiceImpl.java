package com.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.UserShipping;
import com.bookstore.repository.MemShippingRepository;
import com.bookstore.service.MemShippingService;

@Service
public class MemShippingServiceImpl implements MemShippingService {
	
	@Autowired
	private MemShippingRepository memShippingRepository;
	
	
	public UserShipping findById(Long id) {
		return memShippingRepository.findOne(id);
	}
	
	public void removeById(Long id) {
		memShippingRepository.delete(id);
	}

}
