package com.betuluyar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.betuluyar.hrms.business.abstracts.EmployerService;
import com.betuluyar.hrms.business.abstracts.VerificationCodeService;
import com.betuluyar.hrms.core.business.utilities.BusinessRules;
import com.betuluyar.hrms.core.utilities.helpers.CodeGenerator;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.ErrorResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessDataResult;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;
import com.betuluyar.hrms.dataAccess.abstracts.EmployerRepository;
import com.betuluyar.hrms.dataAccess.abstracts.JobAdvertisementRepository;
import com.betuluyar.hrms.entities.concretes.Employer;
import com.betuluyar.hrms.entities.concretes.JobAdvertisement;
import com.betuluyar.hrms.entities.concretes.SystemPersonel;
import com.betuluyar.hrms.entities.concretes.VerificationCode;
import com.betuluyar.hrms.entities.concretes.dto.EmployerForRegisterDto;


@Service
public class EmployerManager implements EmployerService{
	
	private EmployerRepository employerRepository;
	private EmployerService employerService;
	private VerificationCodeService verificationCodeService;
	private CodeGenerator codeGenerator;
	private JobAdvertisementRepository jobAdvertisementRepository;
	
	
	@Autowired
	@Lazy
	public EmployerManager(EmployerRepository employerRepository,EmployerService employerService, VerificationCodeService verificationCodeService,
			CodeGenerator codeGenerator,JobAdvertisementRepository jobAdvertisementRepository	) {
		super();
		this.employerRepository = employerRepository;
		this.employerService=employerService;
		this.codeGenerator=codeGenerator;
		this.verificationCodeService=verificationCodeService;
		this.jobAdvertisementRepository=this.jobAdvertisementRepository;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerRepository.findAll(), "i?? verenler listelendi");
	}

	@Override
	public Result add(EmployerForRegisterDto employerDto) {
		Employer employer=new Employer();
		employer.setCompanyName(employerDto.getCompanyName());
		employer.setWebAddress(employerDto.getWebAddress());
		employer.setEmail(employerDto.getEmailWithSameDomain());
		employer.setPhoneNumber(employerDto.getPhoneNumber());
		employer.setPassword(employerDto.getPassword());
		
		Result businessRulesforEmployer=BusinessRules.run(
		
				isMailAndWebsiteDomainSame(employerDto.getEmailWithSameDomain(),employerDto.getWebAddress()),
				isPasswordsMatch(employerDto.getPassword(), employerDto.getVerifyPassword()),
				isEmployerExistWithEmail(employer.getEmail()),
				checkIfNull(employerDto.getCompanyName(),employerDto.getWebAddress(),employerDto.getPhoneNumber(),employerDto.getEmailWithSameDomain(),employerDto.getPassword(),employerDto.getVerifyPassword())
		);
		if (businessRulesforEmployer != null) return businessRulesforEmployer;
			
		
		String verificationCode=codeGenerator.CodeGenerate();
		verificationCodeRecord(verificationCode, employer.getId(), employer.getEmail());
		verificationBySystemPersonels();
		this.employerRepository.save(employer);
		return new SuccessResult("???? veren eklendi");
	}
	
	private Result checkIfNull(String companyName, String webAddress, String phoneNumber, String emailWithSameDomain,String password, String verifyPassword) {
		if(companyName==null || companyName=="") {
			return new ErrorResult("??irket ad?? bo?? b??rak??lamaz!");
		}
		if(webAddress==null || webAddress=="") {
			return new ErrorResult("??irket web sitesi bo?? b??rak??lamaz!");
		}
		if(phoneNumber==null || phoneNumber=="") {
			return new ErrorResult("??irket telefonu bo?? b??rak??lamaz!");
		}
		if(emailWithSameDomain==null || emailWithSameDomain=="") {
			return new ErrorResult("Email bo?? b??rak??lamaz!");
		}
		if(password==null || password=="") {
			return new ErrorResult("??ifre bo?? b??rak??lamaz!");
		}
		if(verifyPassword==null || verifyPassword=="") {
			return new ErrorResult("??ifre tekrar?? bo?? b??rak??lamaz!");
		}
		return null;
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(this.employerRepository.getByEmail(email));
	}
	
	private Result isMailAndWebsiteDomainSame(String email, String webAdress){
		String[] emailSplit=email.split("@");
		if(!webAdress.contains(emailSplit[1])) {
			return new ErrorResult("Web siteniz ile ayn?? domaine sahip email adresiniz olmal??d??r");
		}
		
		return new SuccessResult();
	}
	
	private Result isPasswordsMatch(String password, String verifyPassword) {
		if(!password.equals(verifyPassword)) {
			return new ErrorResult("??ifre tekrar??yla uyu??muyor!");
		}
		return new SuccessResult();
	}
	
	private Result isEmployerExistWithEmail(String email) {
		if(this.employerService.getByEmail(email).getData()!=null) {
			return new ErrorResult("Bu email ile ba??ka bir kullan??c?? mevcut");
		}
		return new SuccessResult();
	}
	
	private void verificationCodeRecord(String code, long id, String email) {
		VerificationCode verificationCode=new VerificationCode(id,code);
		verificationCodeService.add(verificationCode);
		verificationCode.setConfirmed(true);
		System.out.print(email+" adresine email do??rulama kodu g??nderildi!");
	} 
	private void verificationBySystemPersonels() {
		System.out.print(" Sistem personeli taraf??ndan do??rulama i??lemi ger??ekle??tirildi");
	}

	@Override
	public DataResult<Employer> getById(Long id) {
		
		return new SuccessDataResult<Employer>(this.employerRepository.getById(id));
	}

	

	

	
}
