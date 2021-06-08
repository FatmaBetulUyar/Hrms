package com.betuluyar.hrms.entities.concretes.dto;


import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerForRegisterDto {

	
	private String companyName;
	private String webAddress;
	private String emailWithSameDomain;
	private String phoneNumber;
	private String password;
	private String verifyPassword;
}
