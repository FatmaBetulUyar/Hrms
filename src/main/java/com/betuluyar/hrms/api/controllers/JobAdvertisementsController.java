package com.betuluyar.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betuluyar.hrms.business.abstracts.JobAdvertisementService;
import com.betuluyar.hrms.core.utilities.results.DataResult;
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
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
		
	}
	
	@GetMapping("/getallOrderByReleaseDate")
	public DataResult<List<JobAdvertisement>> getAllOrderByReleaseDate(){
		return this.jobAdvertisementService.getAllOrderByReleaseDate();
	}
	
	@GetMapping("/getallActiveJobAdvertisements")
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisements(){
		return this.jobAdvertisementService.getAllActiveJobAdvertisements();
	}
	
	@GetMapping("/getallActiveJobAdvertisementsByEmployer")
	DataResult<List<JobAdvertisement>> getallActiveJobAdvertisementsByEmployer(@RequestParam long employerId){
		return this.jobAdvertisementService.getallActiveJobAdvertisementsByEmployer(employerId);
	}
	
	@PutMapping("/makePassiveJobAdvertisementByEmployer")
	public Result makePassiveJobAdvertisement( Long id,Long employerId) {
		return this.jobAdvertisementService.makePassiveJobAdvertisement(id, employerId);
	}
}
