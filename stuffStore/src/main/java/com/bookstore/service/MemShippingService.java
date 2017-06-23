package com.bookstore.service;

import com.bookstore.domain.UserShipping;

public interface MemShippingService {
	UserShipping findById(Long id);
	
	void removeById(Long id);
}
