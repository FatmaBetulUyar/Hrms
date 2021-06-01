package com.betuluyar.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betuluyar.hrms.business.abstracts.EmployerService;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	
	private EmployerService employerService;

	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	 
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
		
	}
}
