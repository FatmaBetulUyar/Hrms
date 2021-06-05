package com.betuluyar.hrms.core.adapters;



import java.util.Date;

import com.betuluyar.hrms.core.utilities.results.Result;



public interface JobSeekerCheckService {

	Result checkİfRealPerson(String tc, Date birthDate);
}
