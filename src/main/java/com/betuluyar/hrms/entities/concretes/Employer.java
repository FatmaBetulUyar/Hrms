package com.betuluyar.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employer")
public class Employer extends User{

	@Column(name="company_name")
	private String companyName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="web_address")
	private String webAddress;
	
	public Employer() {
		
	}

	public Employer(String companyName, String phoneNumber, String webAddress) {
		super();
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.webAddress = webAddress;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}
	
}
