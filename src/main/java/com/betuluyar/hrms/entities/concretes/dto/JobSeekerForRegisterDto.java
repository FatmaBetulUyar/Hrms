package com.betuluyar.hrms.entities.concretes.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerForRegisterDto {

	private String firstName;
	private String lastName;
	private String identityNumber;
	private Date birthDate;
	private String email;
	private String password;
	private String verifyPassword;
	
	
	
	
	
	
	
}
