package com.betuluyar.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.betuluyar.hrms.business.abstracts.VerificationCodeService;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;
import com.betuluyar.hrms.dataAccess.abstracts.VerificationCodeRepository;
import com.betuluyar.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService{

	private VerificationCodeRepository verificationCodeRepository;
	
	
	@Autowired
	@Lazy
	public VerificationCodeManager(VerificationCodeRepository verificationCodeRepository) {
		super();
		this.verificationCodeRepository = verificationCodeRepository;
	}

	@Override
	public Result add(VerificationCode verificationCode) {
		this.verificationCodeRepository.save(verificationCode);
		return new SuccessResult("Doğrulama kodu eklendi!");
	}

}
