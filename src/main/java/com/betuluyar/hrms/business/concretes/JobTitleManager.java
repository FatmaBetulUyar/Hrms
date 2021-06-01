package com.betuluyar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betuluyar.hrms.business.abstracts.JobTitleService;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.SuccessDataResult;
import com.betuluyar.hrms.dataAccess.abstracts.JobTitleRepository;
import com.betuluyar.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{
	
	private JobTitleRepository jobTitleRepository;
	

	@Autowired
	public JobTitleManager(JobTitleRepository jobTitleRepository) {
		super();
		this.jobTitleRepository = jobTitleRepository;
	}



	@Override
	public DataResult<List<JobTitle>> getAll() {
		
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleRepository.findAll(), "İş pozisyonları listelendi.");
				
	
	}

}
