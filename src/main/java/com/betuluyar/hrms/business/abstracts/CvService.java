package com.betuluyar.hrms.business.abstracts;



import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.Cv;
import com.betuluyar.hrms.entities.concretes.dto.CvDto;


public interface CvService {
	
	Result add(CvDto cvDto);
	/* DataResult<Cv> getCvByJobSeeker(Long jobSeekerId); */

	DataResult<Cv> getById(Long id);
}
