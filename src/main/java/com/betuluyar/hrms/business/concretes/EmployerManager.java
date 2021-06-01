package com.betuluyar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betuluyar.hrms.business.abstracts.EmployerService;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessDataResult;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;
import com.betuluyar.hrms.dataAccess.abstracts.EmployerRepository;
import com.betuluyar.hrms.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService{
	
	private EmployerRepository employerRepository;
	
	
	@Autowired
	public EmployerManager(EmployerRepository employerRepository) {
		super();
		this.employerRepository = employerRepository;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerRepository.findAll(), "iş verenler listelendi");
	}

	@Override
	public Result add(Employer employer) {
		this.employerRepository.save(employer);
		return new SuccessResult("İş veren eklendi");
	}

}
