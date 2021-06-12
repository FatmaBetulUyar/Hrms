package com.betuluyar.hrms.business.abstracts;

import java.util.List;

import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.School;

public interface SchoolService {

	Result add(School school);
	DataResult<List<School>> getall();
	DataResult<List<School>> getallByGraduationDate();
}
