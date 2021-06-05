package com.betuluyar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.betuluyar.hrms.business.abstracts.JobSeekerService;
import com.betuluyar.hrms.core.adapters.JobSeekerCheckService;
import com.betuluyar.hrms.core.business.utilities.BusinessRules;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.ErrorResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessDataResult;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;
import com.betuluyar.hrms.dataAccess.abstracts.JobSeekerRepository;
import com.betuluyar.hrms.dataAccess.abstracts.UserRepository;
import com.betuluyar.hrms.entities.concretes.JobSeeker;
import com.betuluyar.hrms.entities.concretes.dto.JobSeekerForRegisterDto;


 

@Service
public class JobSeekerManager implements JobSeekerService{

	 private JobSeekerRepository jobSeekerRepository;
	 private JobSeekerCheckService jobSeekerCheckService; 
	 private JobSeekerService jobSeekerService;

	@Autowired
	@Lazy
	public JobSeekerManager(JobSeekerRepository jobSeekerRepository,JobSeekerCheckService jobSeekerCheckService,JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerRepository = jobSeekerRepository;
		this.jobSeekerCheckService=jobSeekerCheckService; 
		this.jobSeekerService=jobSeekerService;
		
	}

	@Override
	public Result add(JobSeekerForRegisterDto jobSeekerDto) {
		JobSeeker entity=new JobSeeker();
		entity.setFirstName(jobSeekerDto.getFirstName());
		entity.setLastName(jobSeekerDto.getLastName());
		entity.setIdentityNumber(jobSeekerDto.getIdentityNumber());
		entity.setBirthDate(jobSeekerDto.getBirthDate());
		entity.setEmail(jobSeekerDto.getEmail());
		entity.setPassword(jobSeekerDto.getPassword());
		//entity.setPassword(jobSeekerDto.getVerifyPassword());
		
		 jobSeekerCheckService.checkİfRealPerson(entity.getIdentityNumber(), entity.getBirthDate());
				Result businessRules=BusinessRules.run(
						isUserExistWithEmail(entity.getEmail()),
						isUserExistWithNationalityId(entity.getIdentityNumber()),
						isPasswordsMatch(jobSeekerDto.getPassword(), jobSeekerDto.getVerifyPassword())
						);
				if (businessRules != null) return businessRules;
				
				

		 this.jobSeekerRepository.save(entity);
			return new SuccessResult("İş arayan kaydı eklendi. Emailinize gelen doğrulama koduyla hesabınızı doğrulayın. ");
	}


	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerRepository.findAll(),"İş arayanlar listelendi");
	}

	@Override
	public DataResult<JobSeeker> getByEmail(String email) {
		
		return new SuccessDataResult<JobSeeker>(this.jobSeekerRepository.getByEmail(email)) ;
		 
	}

	private Result isUserExistWithEmail(String email) {
		if(this.jobSeekerService.getByEmail(email).getData()!=null) {
			return new ErrorResult("Bu email ile başka bir kullanıcı mevcut");
		}
		return new SuccessResult();
	}

	private Result isUserExistWithNationalityId(String identityNumber) {
		if(this.jobSeekerRepository.findByIdentityNumber(identityNumber)!=null) {
			return new ErrorResult("Bu tc nolu başka bir kullanıcı mevcut");
		}
		return new SuccessResult();
	}


	private Result isPasswordsMatch(String password, String confirmPassword) {
		if(!password.equals(confirmPassword)) {
			return new ErrorResult("Şifre tekrarıyla uyuşmuyor!");
		}
		return new SuccessResult();
	}
	 
	
}
