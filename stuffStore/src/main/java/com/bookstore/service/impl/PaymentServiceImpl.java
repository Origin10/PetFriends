package com.bookstore.service.impl;

import org.springframework.stereotype.Service;

import com.bookstore.domain.Payment;
import com.bookstore.domain.MemPayment;
import com.bookstore.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	public Payment setByUserPayment(MemPayment memPayment, Payment payment) {
		payment.setType(memPayment.getType());
		payment.setHolderName(memPayment.getHolderName());
		payment.setCardNumber(memPayment.getCardNumber());
		payment.setExpiryMonth(memPayment.getExpiryMonth());
		payment.setExpiryYear(memPayment.getExpiryYear());
		payment.setCvc(memPayment.getCvc());
		
		return payment;
	}

}
