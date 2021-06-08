package com.betuluyar.hrms.entities.concretes.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.betuluyar.hrms.entities.concretes.City;
import com.betuluyar.hrms.entities.concretes.Employer;
import com.betuluyar.hrms.entities.concretes.JobTitle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdversementDto {
	
	@NotBlank(message ="İş tanımı boş bırakılamaz!")
	private String jobDescription;
	
	private double minSalary;
	private double maxSalary;
	private boolean isActive;
	
	//@NotBlank(message ="Açık pozisyon adedi boş bırakılamaz!")
	private int totalJobTitle;
	
	private Date releaseDate;
	private Date applicationDeadline;
	
	//@NotBlank(message ="Şehir seçimi boş bırakılamaz!")
	private Long cityId;
	
	//@NotBlank(message ="İş veren boş bırakılamaz!")
	private Long employerId;
	
	//@NotBlank(message ="İş pozisyonu boş bırakılamaz!")
	private int jobTitleId;
	
	
}
