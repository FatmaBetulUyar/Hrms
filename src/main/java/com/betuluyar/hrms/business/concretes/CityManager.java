package com.betuluyar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betuluyar.hrms.business.abstracts.CityService;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessDataResult;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;
import com.betuluyar.hrms.dataAccess.abstracts.CityRepository;
import com.betuluyar.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityRepository cityRepository;
	
	
	@Autowired
	public CityManager(CityRepository cityRepository) {
		super();
		this.cityRepository = cityRepository;
	}

	@Override
	public DataResult<City> getById(Long id) {
		return new SuccessDataResult<City>(this.cityRepository.getById(id)) ;
	}

	@Override
	public DataResult<List<City>> getAll() {
		
		return new SuccessDataResult<List<City>>(this.cityRepository.findAll(),"Şehirler listelendi");
	}

	@Override
	public Result add(City city) {
		this.cityRepository.save(city);
		return new SuccessResult("şehir eklendi");
	}

}
