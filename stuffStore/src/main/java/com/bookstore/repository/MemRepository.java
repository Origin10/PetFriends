package com.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.Mem;

public interface MemRepository extends CrudRepository<Mem, Long> {
	Mem findByUsername(String username);
	
	Mem findByEmail(String email);
}
