package com.bookstore.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MemBilling {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String memBillingName;
	private String memBillingStreet1;
	private String memBillingStreet2;
	private String memBillingCity;
	private String memBillingState;
	private String memBillingCountry;
	private String memBillingZipcode;
	
	@OneToOne(cascade=CascadeType.ALL)
	private MemPayment memPayment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemBillingName() {
		return memBillingName;
	}

	public void setMemBillingName(String memBillingName) {
		this.memBillingName = memBillingName;
	}

	public String getMemBillingStreet1() {
		return memBillingStreet1;
	}

	public void setMemBillingStreet1(String memBillingStreet1) {
		this.memBillingStreet1 = memBillingStreet1;
	}

	public String getMemBillingStreet2() {
		return memBillingStreet2;
	}

	public void setMemBillingStreet2(String memBillingStreet2) {
		this.memBillingStreet2 = memBillingStreet2;
	}

	public String getMemBillingCity() {
		return memBillingCity;
	}

	public void setMemBillingCity(String memBillingCity) {
		this.memBillingCity = memBillingCity;
	}

	public String getMemBillingState() {
		return memBillingState;
	}

	public void setMemBillingState(String memBillingState) {
		this.memBillingState = memBillingState;
	}

	public String getMemBillingCountry() {
		return memBillingCountry;
	}

	public void setMemBillingCountry(String memBillingCountry) {
		this.memBillingCountry = memBillingCountry;
	}

	public String getMemBillingZipcode() {
		return memBillingZipcode;
	}

	public void setMemBillingZipcode(String memBillingZipcode) {
		this.memBillingZipcode = memBillingZipcode;
	}

	public MemPayment getMemPayment() {
		return memPayment;
	}

	public void setMemPayment(MemPayment memPayment) {
		this.memPayment = memPayment;
	}
	
	
}
