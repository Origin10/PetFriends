package com.bookstore.service;

import com.bookstore.domain.MemPayment;

public interface MemPaymentService {
	MemPayment findById(Long id);
	
	void removeById(Long id);
}
