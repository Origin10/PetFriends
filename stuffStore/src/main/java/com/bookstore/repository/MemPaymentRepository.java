package com.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.MemPayment;

public interface MemPaymentRepository extends CrudRepository<MemPayment, Long>{

}
