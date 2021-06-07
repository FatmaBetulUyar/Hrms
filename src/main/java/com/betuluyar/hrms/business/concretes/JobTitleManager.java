package com.betuluyar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.betuluyar.hrms.business.abstracts.JobTitleService;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.ErrorResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessDataResult;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;
import com.betuluyar.hrms.dataAccess.abstracts.JobTitleRepository;
import com.betuluyar.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{
	
	private JobTitleRepository jobTitleRepository;
	

	@Autowired
	@Lazy
	public JobTitleManager(JobTitleRepository jobTitleRepository) {
		super();
		this.jobTitleRepository = jobTitleRepository;
	}

	
	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleRepository.findAll(), "İş pozisyonları listelendi.");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		JobTitle result=this.jobTitleRepository.getByTitleName(jobTitle.getTitleName());
		
		  if(result!=null) 
			  return new ErrorResult("iş Pozisyonları tekrar edemez!");
		 
		
		this.jobTitleRepository.save(jobTitle);
		return new SuccessResult("İş pozisyonu eklendi");
	}


	@Override
	public DataResult<JobTitle> getById(int id) {
		
		return new SuccessDataResult<JobTitle>(this.jobTitleRepository.getById(id));
	}


	




	

}
