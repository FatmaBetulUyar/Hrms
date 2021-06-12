package com.betuluyar.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betuluyar.hrms.business.abstracts.SchoolService;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@PostMapping("/add")
	Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}
	
	@GetMapping("/getall")
	public DataResult<List<School>> getall(){
		return this.schoolService.getall();
	}
	
	@GetMapping("/getallByGraduationDate")
	public DataResult<List<School>> getallByGraduationDate(){
		return this.schoolService.getallByGraduationDate();
	}
}
