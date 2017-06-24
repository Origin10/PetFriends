package com.bookstore.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.bookstore.domain.*;
import com.bookstore.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.domain.MemShipping;
import com.bookstore.domain.security.PasswordResetToken;
import com.bookstore.domain.security.UserRole;
import com.bookstore.service.MemService;

@Service
public class MemServiceImpl implements MemService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MemService.class);
	
	@Autowired
	private MemRepository memRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private MemPaymentRepository memPaymentRepository;
	
	@Autowired
	private MemShippingRepository memShippingRepository;
	
	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;
	
	@Override
	public PasswordResetToken getPasswordResetToken(final String token) {
		return passwordResetTokenRepository.findByToken(token);
	}
	
	@Override
	public void createPasswordResetTokenForMem(final Mem user, final String token) {
		final PasswordResetToken myToken = new PasswordResetToken(token, user);
		passwordResetTokenRepository.save(myToken);
	}
	
	@Override
	public Mem findByMemname(String username) {
		return memRepository.findByUsername(username);
	}
	
	@Override
	public Mem findById(Long id){
		return memRepository.findOne(id);
	}
	
	@Override
	public Mem findByEmail (String email) {
		return memRepository.findByEmail(email);
	}
	
	@Override
	@Transactional
	public Mem createMem(Mem user, Set<UserRole> userRoles){
		Mem localMem = memRepository.findByUsername(user.getUsername());
		
		if(localMem != null) {
			LOG.info("user {} already exists. Nothing will be done.", user.getUsername());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setMem(user);
			user.setShoppingCart(shoppingCart);
			
			user.setMemShippingList(new ArrayList<MemShipping>());
			user.setMemPaymentList(new ArrayList<MemPayment>());
			
			localMem = memRepository.save(user);
		}
		
		return localMem;
	}
	
	@Override
	public Mem save(Mem user) {
		return memRepository.save(user);
	}
	
	@Override
	public void updateMemBilling(MemBilling memBilling, MemPayment memPayment, Mem user) {
		memPayment.setMem(user);
		memPayment.setMemBilling(memBilling);
		memPayment.setDefaultPayment(true);
		memBilling.setMemPayment(memPayment);
		user.getMemPaymentList().add(memPayment);
		save(user);
	}
	
	@Override
	public void updateMemShipping(MemShipping memShipping, Mem user){
		memShipping.setMem(user);
		memShipping.setMemShippingDefault(true);
		user.getMemShippingList().add(memShipping);
		save(user);
	}
	
	@Override
	public void setMemDefaultPayment(Long userPaymentId, Mem user) {
		List<MemPayment> memPaymentList = (List<MemPayment>) memPaymentRepository.findAll();
		
		for (MemPayment memPayment : memPaymentList) {
			if(memPayment.getId() == userPaymentId) {
				memPayment.setDefaultPayment(true);
				memPaymentRepository.save(memPayment);
			} else {
				memPayment.setDefaultPayment(false);
				memPaymentRepository.save(memPayment);
			}
		}
	}
	
	@Override
	public void setMemDefaultShipping(Long userShippingId, Mem user) {
		List<MemShipping> memShippingList = (List<MemShipping>) memShippingRepository.findAll();
		
		for (MemShipping memShipping : memShippingList) {
			if(memShipping.getId() == userShippingId) {
				memShipping.setMemShippingDefault(true);
				memShippingRepository.save(memShipping);
			} else {
				memShipping.setMemShippingDefault(false);
				memShippingRepository.save(memShipping);
			}
		}
	}

}
