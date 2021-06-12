package com.betuluyar.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betuluyar.hrms.business.abstracts.CvService;
import com.betuluyar.hrms.core.utilities.files.FileService;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessDataResult;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;
import com.betuluyar.hrms.dataAccess.abstracts.CvRepository;
import com.betuluyar.hrms.dataAccess.abstracts.ForeignLanguageRepository;
import com.betuluyar.hrms.dataAccess.abstracts.JobExperienceRepository;
import com.betuluyar.hrms.dataAccess.abstracts.PhotoRepository;
import com.betuluyar.hrms.dataAccess.abstracts.SchoolRepository;
import com.betuluyar.hrms.entities.concretes.Cv;
import com.betuluyar.hrms.entities.concretes.ForeignLanguage;
import com.betuluyar.hrms.entities.concretes.JobExperience;
import com.betuluyar.hrms.entities.concretes.School;
import com.betuluyar.hrms.entities.concretes.dto.CvDto;

@Service
public class CvManager implements CvService{

	private CvRepository cvRepository;
	
	private final SchoolRepository schoolRepository;
	
	private final JobExperienceRepository jobExperienceRepository;
	
	private final ForeignLanguageRepository foreignLanguageRepository;
	
	private final PhotoRepository photoRepository;
	
	private final FileService fileService;
	
	
	
	
	@Autowired
	public CvManager(CvRepository cvRepository, SchoolRepository schoolRepository, JobExperienceRepository jobExperienceRepository, ForeignLanguageRepository foreignLanguageRepository, FileService fileService, PhotoRepository photoRepository) {
		super();
		this.schoolRepository = schoolRepository;
		this.cvRepository = cvRepository;
		this.jobExperienceRepository = jobExperienceRepository;
		this.foreignLanguageRepository = foreignLanguageRepository;
		this.photoRepository = photoRepository;
		this.fileService = fileService;
	}


	@Override
	public Result add(CvDto cvDto) {
		Cv cv = new Cv();
		List<School> schools = new ArrayList<>();
		List<JobExperience> jobExperiences=new ArrayList<>();
		List<ForeignLanguage> foreignLanguages=new ArrayList<>();
		
		
		
		cv.setGithubAdress(cvDto.getGithubAdress());
		cv.setLinkedinAdress(cvDto.getLinkedinAdress());
	
		//cv.setPhoto(this.fileService.upload(cvDto.getPhoto()));
		
		cv.setTechnologies(cvDto.getTechnologies());
		cv.setCoverLetter(cvDto.getCoverLetter());
		
		final Cv cvDb = cvRepository.save(cv);
		
		cv.setJobSeeker(cvDto.getJobSeeker());
		
		for(School sc: cvDto.getSchools()) {
			School school = new School();
			school.setCv(cvDb);
			school.setDepartment(sc.getDepartment());
			school.setGraduationDate(sc.getGraduationDate());
			school.setSchoolName(sc.getSchoolName());
			school.setStartDate(sc.getStartDate());
			schools.add(school);
		}
		
		schoolRepository.saveAll(schools);
		
		for(JobExperience je: cvDto.getJobExperiences()) {
			JobExperience jobExperience=new JobExperience();
			jobExperience.setCv(cvDb);
			jobExperience.setPosition(je.getPosition());
			jobExperience.setWorkplaceName(je.getWorkplaceName());
			jobExperience.setStartDate(je.getStartDate());
			jobExperience.setEndDate(je.getEndDate());
			jobExperiences.add(jobExperience);
		}
		
		jobExperienceRepository.saveAll(jobExperiences);
		
		for(ForeignLanguage fl:cvDto.getForeignLanguge()) {
			ForeignLanguage foreignLanguage=new ForeignLanguage();
			foreignLanguage.setCv(cvDb);
			foreignLanguage.setLanguageName(fl.getLanguageName());
			foreignLanguage.setLevel(fl.getLevel());
			foreignLanguages.add(foreignLanguage);
		}
		
		foreignLanguageRepository.saveAll(foreignLanguages);
		
		return new SuccessResult("Cv eklendi");
	}


	@Override
	public DataResult<Cv> getById(Long id) {
		
		return new SuccessDataResult<Cv>(this.cvRepository.getById(id));
	}


	

	

}
