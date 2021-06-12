package com.betuluyar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betuluyar.hrms.business.abstracts.SchoolService;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessDataResult;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;
import com.betuluyar.hrms.dataAccess.abstracts.SchoolRepository;
import com.betuluyar.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{

	private SchoolRepository schoolRepository;
	
	@Autowired
	public SchoolManager(SchoolRepository schoolRepository) {
		super();
		this.schoolRepository = schoolRepository;
	}


	@Override
	public Result add(School school) {
		this.schoolRepository.save(school);
		return new SuccessResult("Okul eklendi!");
	}


	@Override
	public DataResult<List<School>> getall() {
		return new SuccessDataResult<List<School>>(this.schoolRepository.findAll(), "Okullar listelendi");
	}


	@Override
	public DataResult<List<School>> getallByGraduationDate() {
			
		return new SuccessDataResult<List<School>>(this.schoolRepository.getByOrderByGraduationDateDesc(), "Okullar mezuniyet yılına göre sıralandı");
	}

}
