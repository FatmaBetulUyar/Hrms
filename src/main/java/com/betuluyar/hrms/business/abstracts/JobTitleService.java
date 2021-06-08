package com.betuluyar.hrms.business.abstracts;

import java.util.List;

import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.JobTitle;

public interface JobTitleService {


	
	DataResult<List<JobTitle>>  getAll();
	Result add(JobTitle jobTitle);
	DataResult<JobTitle> getById(Long id);
	
}
