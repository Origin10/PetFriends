package com.bookstore.service;

import java.util.Set;

import com.bookstore.domain.Mem;
import com.bookstore.domain.MemBilling;
import com.bookstore.domain.MemShipping;
import com.bookstore.domain.MemPayment;
import com.bookstore.domain.security.PasswordResetToken;
import com.bookstore.domain.security.UserRole;

public interface MemService {
	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetTokenForMem(final Mem mem, final String token);
	
	Mem findByMemname(String memname);
	
	Mem findByEmail (String email);
	
	Mem findById(Long id);
	
	Mem createMem(Mem mem, Set<UserRole> userRoles) throws Exception;
	
	Mem save(Mem mem);
	
	void updateMemBilling(MemBilling memBilling, MemPayment memPayment, Mem mem);
	
	void updateMemShipping(MemShipping memShipping, Mem mem);
	
	void setMemDefaultPayment(Long memPaymentId, Mem mem);
	
	void setMemDefaultShipping(Long memShippingId, Mem mem);
}
