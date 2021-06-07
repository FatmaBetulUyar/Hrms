package com.betuluyar.hrms.entities.concretes.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerDto {

	private String firstName;
	private String lastName;
	private String identityNumber;
	private Date birthDate;
	private String email;
	private String password;
	private String verifyPassword;
	
	
	
	
	
	
	
}
