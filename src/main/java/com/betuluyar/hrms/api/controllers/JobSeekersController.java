package com.betuluyar.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betuluyar.hrms.business.abstracts.JobSeekerService;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.JobSeeker;
import com.betuluyar.hrms.entities.concretes.dto.JobSeekerForRegisterDto;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {
	
	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
	}
	@PostMapping("/add")
	public Result add(@Valid @RequestBody  JobSeekerForRegisterDto jobSeekerDto) {
		 return this.jobSeekerService.add(jobSeekerDto);
	}
	
	
	//post isteği
	//servise katmanı
	//dto 
	//manager içine save fonksiyonu
	//service içinde repository çağır
	//controller=> service => repository

}
