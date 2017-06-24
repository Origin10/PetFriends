package com.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.MemPayment;
import com.bookstore.repository.MemPaymentRepository;
import com.bookstore.service.MemPaymentService;

@Service
public class MemPaymentServiceImpl implements MemPaymentService {

	@Autowired
	private MemPaymentRepository memPaymentRepository;
		
	public MemPayment findById(Long id) {
		return memPaymentRepository.findOne(id);
	}
	
	public void removeById(Long id) {
		memPaymentRepository.delete(id);
	}
} 
