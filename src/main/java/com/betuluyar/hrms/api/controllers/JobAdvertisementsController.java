package com.betuluyar.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betuluyar.hrms.business.abstracts.JobAdvertisementService;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.JobAdvertisement;
import com.betuluyar.hrms.entities.concretes.dto.JobAdversementDto;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {

	JobAdvertisementService jobAdvertisementService;
	
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}



	@PostMapping("/addJobAdvertisement")
	public Result addJobAdvertisement(@Valid @RequestBody JobAdversementDto dto) {
		return this.jobAdvertisementService.addJobAdvertisement(dto);
	}
}
