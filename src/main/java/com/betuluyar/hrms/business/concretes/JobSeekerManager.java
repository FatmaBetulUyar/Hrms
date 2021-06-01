package com.betuluyar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.betuluyar.hrms.business.abstracts.JobSeekerService;
import com.betuluyar.hrms.core.adapters.JobSeekerCheckService;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.ErrorResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessDataResult;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;
import com.betuluyar.hrms.dataAccess.abstracts.JobSeekerRepository;
import com.betuluyar.hrms.entities.concretes.JobSeeker;
import com.betuluyar.hrms.entities.concretes.dto.JobSeekerDto;

 

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerRepository jobSeekerRepository;
	/* private JobSeekerCheckService jobSeekerCheckService; */

	@Autowired
	@Lazy
	public JobSeekerManager(JobSeekerRepository jobSeekerRepository) {
		super();
		this.jobSeekerRepository = jobSeekerRepository;
		/* this.jobSeekerCheckService=jobSeekerCheckService; */
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if(!firstNameCheck(jobSeeker)) {
			return new ErrorResult("Ad kısmı boş bırakılamaz!");
		}
		else if(!lastNameCheck(jobSeeker)) {
			return new ErrorResult("Soyad kısmı boş bırakılamaz!");
		}
		else if(!identityNumberCheck(jobSeeker)) {
			return new ErrorResult("Tc no kısmı boş bırakılamaz!");
		}
		/*
		 * else if(!birthDateCheck(jobSeeker)) { return new
		 * ErrorResult("Doğum tarihi kısmı boş bırakılamaz!"); }
		 */

		/*
		 * else if(!mernisCheck( jobSeeker)) { return new
		 * ErrorResult("Mernis doğrulaması gerçekleştirilemedi!");
		 * 
		 * }
		 */
				


		this.jobSeekerRepository.save(jobSeeker);
		return new SuccessResult("Jobseeker eklendi ");
	}

	

	

	

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerRepository.findAll(),"İş arayanlar listelendi");
	}

	
	private boolean firstNameCheck(JobSeeker jobSeeker) {
		if(jobSeeker.getFirstName().isEmpty()) {
			return false;
		}
		return true;
	}

	private boolean lastNameCheck(JobSeeker jobSeeker) {
		if(jobSeeker.getLastName().isEmpty()) {
			return false;
		}
		return true;
	}
	

	private boolean identityNumberCheck(JobSeeker jobSeeker) {
		if(jobSeeker.getIdentityNumber().isEmpty()) {
			return false;
		}
		return true;
	}

	/*
	 * private boolean birthDateCheck(JobSeeker jobSeeker) {
	 * if(jobSeeker.getBirthDate()!=(Integer)null) { return true; } return false; }
	 */
	
	/*
	 * private boolean mernisCheck(JobSeeker jobSeeker) {
	 * if(jobSeekerCheckService.checkİfRealPerson(jobSeeker)) { return true; }
	 * return false; }
	 */
	 
	
}
