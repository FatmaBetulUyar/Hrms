package com.betuluyar.hrms.business.abstracts;

import java.util.List;

import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.JobSeeker;
import com.betuluyar.hrms.entities.concretes.dto.JobSeekerForRegisterDto;

public interface JobSeekerService {

	DataResult<List<JobSeeker>> getAll();
	Result add(JobSeekerForRegisterDto jobSeekerDto);
	DataResult<JobSeeker> getByEmail(String email);
	
}
