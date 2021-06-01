package com.betuluyar.hrms.entities.concretes.dto;

import java.util.Date;

import lombok.Data;

@Data
public class JobSeekerDto {

	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String identityNumber;
	private Date birthDate;
	
	public  JobSeekerDto() {
		
	}
	
	
	
}
