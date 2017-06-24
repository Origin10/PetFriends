package com.bookstore.service.impl;

import org.springframework.stereotype.Service;

import com.bookstore.domain.BillingAddress;
import com.bookstore.domain.MemBilling;
import com.bookstore.service.BillingAddressService;

@Service
public class BillingAddressServiceImpl implements BillingAddressService{
	
	public BillingAddress setByMemBilling(MemBilling memBilling, BillingAddress billingAddress) {
		billingAddress.setBillingAddressName(memBilling.getMemBillingName());
		billingAddress.setBillingAddressStreet1(memBilling.getMemBillingStreet1());
		billingAddress.setBillingAddressStreet2(memBilling.getMemBillingStreet2());
		billingAddress.setBillingAddressCity(memBilling.getMemBillingCity());
		billingAddress.setBillingAddressState(memBilling.getMemBillingState());
		billingAddress.setBillingAddressCountry(memBilling.getMemBillingCountry());
		billingAddress.setBillingAddressZipcode(memBilling.getMemBillingZipcode());
		
		return billingAddress;
	}

}
