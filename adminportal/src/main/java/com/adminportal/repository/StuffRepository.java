package com.adminportal.repository;

import org.springframework.data.repository.CrudRepository;

import com.adminportal.domain.Book;

public interface StuffRepository extends CrudRepository<Book, Long>{

}
