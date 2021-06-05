package com.betuluyar.hrms.business.abstracts;

import java.util.List;

import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.Employer;
import com.betuluyar.hrms.entities.concretes.dto.EmployerForRegisterDto;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	Result add(EmployerForRegisterDto employerDto);
	DataResult<Employer> getByEmail(String email);
}
