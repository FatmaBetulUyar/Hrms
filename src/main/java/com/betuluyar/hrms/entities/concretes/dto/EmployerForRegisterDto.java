package com.betuluyar.hrms.entities.concretes.dto;


import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerForRegisterDto {

	@NotBlank(message="Şirket adı boş bırakılamaz!")
	private String companyName;
	
	@NotBlank(message="Web sitesi boş bırakılamaz!")
	private String webAddress;
	
	@NotBlank(message="Email boş bırakılamaz!")
	private String emailWithSameDomain;
	

	@NotBlank(message="Telefon numarası boş bırakılamaz!")
	private String phoneNumber;
	
	@NotBlank(message="Şifre boş bırakılamaz!")
	private String password;
	
	@NotBlank(message="Şifre tekrarı boş bırakılamaz!")
	private String verifyPassword;
}
