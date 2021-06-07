package com.betuluyar.hrms.business.abstracts;

import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.JobAdvertisement;
import com.betuluyar.hrms.entities.concretes.dto.JobAdversementDto;

public interface JobAdvertisementService {
	Result addJobAdvertisement(JobAdversementDto jobAdvertisement);
}
