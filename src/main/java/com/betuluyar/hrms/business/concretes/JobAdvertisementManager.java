package com.betuluyar.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.betuluyar.hrms.entities.concretes.dto.JobAdversementDto;
import com.betuluyar.hrms.business.abstracts.CityService;
import com.betuluyar.hrms.business.abstracts.EmployerService;
import com.betuluyar.hrms.business.abstracts.JobAdvertisementService;
import com.betuluyar.hrms.business.abstracts.JobTitleService;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;
import com.betuluyar.hrms.dataAccess.abstracts.CityRepository;
import com.betuluyar.hrms.dataAccess.abstracts.JobAdvertisementRepository;
import com.betuluyar.hrms.entities.concretes.JobAdvertisement;
import com.betuluyar.hrms.entities.concretes.JobTitle;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementRepository jobAdvertisementRepository;
	private CityService cityService;
	private JobTitleService jobTitleService;
	private EmployerService employerService;
	
	
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementRepository jobAdvertisementRepository,CityService cityService,JobTitleService jobTitleService,EmployerService employerService) {
		super();
		this.jobAdvertisementRepository = jobAdvertisementRepository;
		this.cityService=cityService;
		this.employerService=employerService;
		this.jobTitleService=jobTitleService;
	}


	@Override
	public Result addJobAdvertisement(JobAdversementDto dto) {
		JobAdvertisement entity=new JobAdvertisement();
		//JobTitle jobTitle=new JobTitle();
		entity.setJobDescription(dto.getJobDescription());
		entity.setMinSalary(dto.getMinSalary());
		entity.setMaxSalary(dto.getMaxSalary());
		entity.setActive(dto.isActive()); ;
		entity.setTotalJobTitle(dto.getTotalJobTitle());
		entity.setApplicationDeadline(dto.getApplicationDeadline());
		
		entity.setCity(this.cityService.getById(dto.getCityId()).getData()); 
		entity.setEmployer(this.employerService.getById(dto.getEmployerId()).getData());
		entity.setJobTitle(this.jobTitleService.getById(dto.getJobTitleId()).getData());
		
		this.jobAdvertisementRepository.save(entity);
		
		
		return new SuccessResult("iş ilanı eklendi");
	}

}
