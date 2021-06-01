package com.betuluyar.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betuluyar.hrms.business.abstracts.SystemPersonelService;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.SystemPersonel;

@RestController
@RequestMapping("/api/systempersonels")
public class SystemPersonelsController {

	private SystemPersonelService systemPersonelService;

	public SystemPersonelsController(SystemPersonelService systemPersonelService) {
		super();
		this.systemPersonelService = systemPersonelService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<SystemPersonel>> getAll(){
		return this.systemPersonelService.getAll();
	}
	
	@PostMapping("add")
	public Result add(@RequestBody SystemPersonel systemPersonel) {
		return this.systemPersonelService.add(systemPersonel);
	}
	
}
