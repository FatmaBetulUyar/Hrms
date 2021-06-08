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
	
	
	private String jobDescription;
	private double minSalary;
	private double maxSalary;
	private boolean isActive;
	private int totalJobTitle;
	private Date releaseDate;
	private Date applicationDeadline;
	
	private Long cityId;
	private Long employerId;
	private Long jobTitleId;
	
	
}
