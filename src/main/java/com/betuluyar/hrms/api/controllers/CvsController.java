package com.betuluyar.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betuluyar.hrms.business.abstracts.CvService;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.dto.CvDto;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {
	
	private CvService cvService;
	

	@Autowired
	public CvsController(CvService cvService) {
		super();
		this.cvService = cvService;
	}


	@PostMapping("/add")
	public Result add(@RequestBody CvDto dto) {
		return this.cvService.add(dto);
	}
	
	/*
	 * @GetMapping("/getCvByJobSeeker") public DataResult<Cv> getCvByJobSeeker(Long
	 * jobSeekerId){ return this.cvService.getCvByJobSeeker(jobSeekerId); }
	 */
}
