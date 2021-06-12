package com.betuluyar.hrms.entities.concretes.dto;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.betuluyar.hrms.entities.concretes.ForeignLanguage;
import com.betuluyar.hrms.entities.concretes.JobExperience;
import com.betuluyar.hrms.entities.concretes.JobSeeker;
import com.betuluyar.hrms.entities.concretes.Photo;
import com.betuluyar.hrms.entities.concretes.School;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {

	private JobSeeker jobSeeker;
	private long id;
	
	private List<School> schools;
	private List<JobExperience> jobExperiences;
	private List<ForeignLanguage> foreignLanguge;
	
	private Photo  photo;
	private String githubAdress;
	private String linkedinAdress;
	private String technologies;
	private String coverLetter;
}
