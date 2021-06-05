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

	@NotBlank(message ="Ad kısmı boş bırakılamaz!")
	private String firstName;
	
	@NotBlank(message ="Soyad kısmı boş bırakılamaz!")
	private String lastName;
	
	@NotBlank(message ="Tc no kısmı boş bırakılamaz!")
	private String identityNumber;
	
	
	private Date birthDate;
	
	@NotBlank(message ="Email kısmı boş bırakılamaz!")
	private String email;
	
	@NotBlank(message ="Şifre kısmı boş bırakılamaz!")
	private String password;
	
	@NotBlank(message ="Şifre tekrarı kısmı boş bırakılamaz!")
	private String verifyPassword;
	
	
	
	
	
	
	
}
