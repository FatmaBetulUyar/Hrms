package com.betuluyar.hrms.business.abstracts;

import java.util.List;

import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.City;

public interface CityService {

	DataResult<City> getById(Long id);
	DataResult<List<City>> getAll();
	Result add(City city);
}
