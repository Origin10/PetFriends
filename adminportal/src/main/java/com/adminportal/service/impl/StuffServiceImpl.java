package com.adminportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal.domain.Book;
import com.adminportal.repository.StuffRepository;
import com.adminportal.service.StuffService;

@Service
public class StuffServiceImpl implements StuffService {
	
	@Autowired
	private StuffRepository stuffRepository;
	
	public Book save(Book book) {
		return stuffRepository.save(book);
	}
	
	public List<Book> findAll() {
		return (List<Book>) stuffRepository.findAll();
	}
	
	public Book findOne(Long id) {
		return stuffRepository.findOne(id);
	}
	
	public void removeOne(Long id) {
		stuffRepository.delete(id);
	}
}
