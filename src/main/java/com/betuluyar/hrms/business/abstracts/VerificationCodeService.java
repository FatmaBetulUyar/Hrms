package com.betuluyar.hrms.business.abstracts;

import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	
	Result add(VerificationCode verificationCode);
	

}
