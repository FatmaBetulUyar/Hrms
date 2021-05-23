package com.betuluyar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betuluyar.hrms.business.abstracts.JobTitleService;
import com.betuluyar.hrms.dataAccess.abstracts.JobTitleDao;
import com.betuluyar.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{
	
	private JobTitleDao jobTitleDao;
	

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}



	@Override
	public List<JobTitle> getAll() {
		
		return this.jobTitleDao.findAll();
	
	}

}
