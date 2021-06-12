package com.betuluyar.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betuluyar.hrms.business.abstracts.ForeignLanguageService;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;
import com.betuluyar.hrms.dataAccess.abstracts.ForeignLanguageRepository;
import com.betuluyar.hrms.entities.concretes.ForeignLanguage;

@Service
public class ForeignLanguageManager implements ForeignLanguageService{

	private ForeignLanguageRepository foreignLanguageRepository;
	
	
	@Autowired
	public ForeignLanguageManager(ForeignLanguageRepository foreignLanguageRepository) {
		super();
		this.foreignLanguageRepository = foreignLanguageRepository;
	}

	@Override
	public Result add(ForeignLanguage foreignLanguage) {
		this.foreignLanguageRepository.save(foreignLanguage);
		return new SuccessResult("Yabancı dil eklendi!");
	}

}
