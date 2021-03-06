package com.betuluyar.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.betuluyar.hrms.business.abstracts.JobSeekerService;
import com.betuluyar.hrms.business.abstracts.VerificationCodeService;
import com.betuluyar.hrms.core.adapters.JobSeekerCheckService;
import com.betuluyar.hrms.core.business.utilities.BusinessRules;
import com.betuluyar.hrms.core.utilities.helpers.CodeGenerator;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.ErrorResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessDataResult;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;
import com.betuluyar.hrms.dataAccess.abstracts.JobSeekerRepository;
import com.betuluyar.hrms.dataAccess.abstracts.UserRepository;
import com.betuluyar.hrms.entities.concretes.JobSeeker;
import com.betuluyar.hrms.entities.concretes.VerificationCode;
import com.betuluyar.hrms.entities.concretes.dto.JobSeekerForRegisterDto;


 

@Service
public class JobSeekerManager implements JobSeekerService{

	 private JobSeekerRepository jobSeekerRepository;
	 private JobSeekerCheckService jobSeekerCheckService; 
	 private JobSeekerService jobSeekerService;
	 private VerificationCodeService verificationCodeService;
	 private CodeGenerator codeGenerator;
	 

	@Autowired
	@Lazy
	public JobSeekerManager(JobSeekerRepository jobSeekerRepository,JobSeekerCheckService jobSeekerCheckService,JobSeekerService jobSeekerService,
			VerificationCodeService verificationCodeService,CodeGenerator codeGenerator) {
		super();
		this.jobSeekerRepository = jobSeekerRepository;
		this.jobSeekerCheckService=jobSeekerCheckService; 
		this.jobSeekerService=jobSeekerService;
		this.verificationCodeService=verificationCodeService;
		this.codeGenerator=codeGenerator;
		
		
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
		
		 jobSeekerCheckService.check??fRealPerson(entity.getIdentityNumber(), entity.getBirthDate());
				Result businessRules=BusinessRules.run(
						isUserExistWithEmail(entity.getEmail()),
						isUserExistWithNationalityId(entity.getIdentityNumber()),
						isPasswordsMatch(jobSeekerDto.getPassword(), jobSeekerDto.getVerifyPassword()),
						checkIfNull(jobSeekerDto.getFirstName(),jobSeekerDto.getLastName(), jobSeekerDto.getIdentityNumber(),jobSeekerDto.getBirthDate(),
								jobSeekerDto.getEmail(),jobSeekerDto.getPassword(),jobSeekerDto.getVerifyPassword())
						);
				if (businessRules != null) return businessRules;
				
				String verificationCode=this.codeGenerator.CodeGenerate();
				verificationCodeRecord(verificationCode,entity.getId(),entity.getEmail());
				
				
		 this.jobSeekerRepository.save(entity);
			return new SuccessResult("???? arayan kayd?? eklendi! ");
	}


	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerRepository.findAll(),"???? arayanlar listelendi");
	}

	@Override
	public DataResult<JobSeeker> getByEmail(String email) {
		
		return new SuccessDataResult<JobSeeker>(this.jobSeekerRepository.getByEmail(email)) ;
		 
	}

	private Result isUserExistWithEmail(String email) {
		if(this.jobSeekerService.getByEmail(email).getData()!=null) {
			return new ErrorResult("Bu email ile ba??ka bir kullan??c?? mevcut");
		}
		return new SuccessResult();
	}

	private Result isUserExistWithNationalityId(String identityNumber) {
		if(this.jobSeekerRepository.findByIdentityNumber(identityNumber)!=null) {
			return new ErrorResult("Bu tc nolu ba??ka bir kullan??c?? mevcut");
		}
		return new SuccessResult();
	}


	private Result isPasswordsMatch(String password, String confirmPassword) {
		if(!password.equals(confirmPassword)) {
			return new ErrorResult("??ifre tekrar??yla uyu??muyor!");
		}
		return new SuccessResult();
	}
	 
	private void verificationCodeRecord(String code, long id, String email) {
		VerificationCode verificationCode=new VerificationCode(id,code);
		verificationCodeService.add(verificationCode);
		verificationCode.setConfirmed(true);
		System.out.print(email+" adresine email do??rulama kodu g??nderildi!");
	}
	

	private Result checkIfNull(String firstName,String lastName, String identityNumber, Date birthDate,String email, String password, String verifyPassword) {
		if(firstName==null || firstName=="") {
			return new ErrorResult("Ad bo?? b??rak??lamaz!");
		}
		if(lastName==null|| lastName=="") {
			return new ErrorResult("Soyad bo?? b??rak??lamaz!");
		}
		if(identityNumber==null|| identityNumber=="") {
			return new ErrorResult("Tc no bo?? b??rak??lamaz!");
		}
		if(birthDate==null) {
			return new ErrorResult("Do??um tarihi bo?? b??rak??lamaz!");
		}
		if(email==null || email=="") {
			return new ErrorResult("Email bo?? b??rak??lamaz!");
		}
		if(password==null|| password=="") {
			return new ErrorResult("??ifre bo?? b??rak??lamaz!");
		}
		if(verifyPassword==null|| verifyPassword=="") {
			return new ErrorResult("??ifre tekrar?? bo?? b??rak??lamaz!");
		}
		
		return new SuccessResult();
	}

	
}
