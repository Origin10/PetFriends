package com.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.UserShipping;

public interface MemShippingRepository extends CrudRepository<UserShipping, Long> {
	
	

}
