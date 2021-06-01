package com.betuluyar.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="job_seeker")
public class JobSeeker extends User {
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="birth_date")
	private int birthDate;
	
	public JobSeeker() {
		
	}
	
	public JobSeeker(String firstName, String lastName, String identityNumber, int birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.identityNumber = identityNumber;
		this.birthDate = birthDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public int getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(int birthDate) {
		this.birthDate = birthDate;
	}

}
