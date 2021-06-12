package com.betuluyar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betuluyar.hrms.business.abstracts.JobExperienceService;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessDataResult;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;
import com.betuluyar.hrms.dataAccess.abstracts.JobExperienceRepository;
import com.betuluyar.hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceRepository jobExperienceRepository;
	
	@Autowired
	public JobExperienceManager(JobExperienceRepository jobExperienceRepository) {
		super();
		this.jobExperienceRepository = jobExperienceRepository;
	}


	@Override
	public Result add(JobExperience jobExperience) {
		this.jobExperienceRepository.save(jobExperience);
		return new SuccessResult("İş tecrübesi eklendi");
	}


	@Override
	public DataResult<List<JobExperience>> getAll() {
		
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceRepository.findAll(),"İş tecrübeleri listelendi!");
	}


	@Override
	public DataResult<List<JobExperience>> getAllByDate() {
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceRepository.getByOrderByEndDateDesc(), "İş tecrübeleri tarihe göre listelendi!");
	}

}
