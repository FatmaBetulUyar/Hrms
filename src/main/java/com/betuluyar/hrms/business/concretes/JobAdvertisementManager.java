package com.betuluyar.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.betuluyar.hrms.entities.concretes.dto.JobAdversementDto;
import com.betuluyar.hrms.business.abstracts.CityService;
import com.betuluyar.hrms.business.abstracts.EmployerService;
import com.betuluyar.hrms.business.abstracts.JobAdvertisementService;
import com.betuluyar.hrms.business.abstracts.JobTitleService;
import com.betuluyar.hrms.core.business.utilities.BusinessRules;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.ErrorResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessDataResult;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;
import com.betuluyar.hrms.dataAccess.abstracts.JobAdvertisementRepository;
import com.betuluyar.hrms.entities.concretes.JobAdvertisement;


@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementRepository jobAdvertisementRepository;
	private CityService cityService;
	private JobTitleService jobTitleService;
	private EmployerService employerService;
	
	
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementRepository jobAdvertisementRepository,CityService cityService,JobTitleService jobTitleService,EmployerService employerService) {
		super();
		this.jobAdvertisementRepository = jobAdvertisementRepository;
		this.cityService=cityService;
		this.employerService=employerService;
		this.jobTitleService=jobTitleService;
	}


	@Override
	public Result addJobAdvertisement(JobAdversementDto dto) {
		JobAdvertisement entity=new JobAdvertisement();
		//JobTitle jobTitle=new JobTitle();
		entity.setJobDescription(dto.getJobDescription());
		entity.setMinSalary(dto.getMinSalary());
		entity.setMaxSalary(dto.getMaxSalary());
		entity.setActive(dto.isActive()); ;
		entity.setTotalJobTitle(dto.getTotalJobTitle());
		entity.setReleaseDate(new Date());
		entity.setApplicationDeadline(dto.getApplicationDeadline());
		
		entity.setCity(this.cityService.getById(dto.getCityId()).getData()); 
		entity.setEmployer(this.employerService.getById(dto.getEmployerId()).getData());
		entity.setJobTitle(this.jobTitleService.getById(dto.getJobTitleId()).getData());
		
		Result businessRules=BusinessRules.run(
				checkIfJobDescriptionisValid(dto.getJobDescription()),
				checkIfJobTitleisValid(dto.getJobTitleId()),
				checkIfCityisValid(dto.getCityId()),
				checkIfTotalJobTitle(dto.getTotalJobTitle())
				);
		if(businessRules!=null)
			return businessRules;
		
		
		this.jobAdvertisementRepository.save(entity);
		return new SuccessResult("i?? ilan?? eklendi");
	}




	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementRepository.findAll(), "???? ilanlar?? listelendi");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getAllOrderByReleaseDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementRepository.findByOrderByReleaseDate(),"???? ilanlar?? tarihe g??re s??raland??");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveJobAdvertisements() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementRepository.getByIsActive(true), "Akfif i?? ilanlar?? listelendi");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getallActiveJobAdvertisementsByEmployer(long employerId) {

		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementRepository.getByIsActiveAndEmployer(true, employerId), "??irkete ait aktif i?? ilanlar?? listelendi.");
	}


	
	@Override
	public Result makePassiveJobAdvertisement(Long id,Long employerId) {
		JobAdvertisement jobAdvertisement=this.jobAdvertisementRepository.findByIdAndEmployer_Id(id, employerId);
		jobAdvertisement.setActive(!jobAdvertisement.isActive());
		this.jobAdvertisementRepository.save(jobAdvertisement);
		return new SuccessResult(employerId+" id numaras??na sahip ??irket taraf??ndan "+ id+" id li i?? ilan??" +(jobAdvertisement.isActive() ? "aktif":"pasif"+ " hale getirildi."));
	}

	

	private Result checkIfJobDescriptionisValid(String jobDescription) {
		if(jobDescription==null ||jobDescription=="") {
			return new ErrorResult("???? tan??m?? girilmesi zorunludur."); 
		}
		return new SuccessResult();
		
	}
	private Result checkIfJobTitleisValid(Long id) {
		if(id<=0) {
			return new ErrorResult("???? pozisyonu bo?? b??rak??lamaz!");
		}
		if(this.jobTitleService.getById(id).getData()==null) {
			return new ErrorResult("B??yle bir i?? pozisyonu yok!");
		}
		return new SuccessResult();
	}
	
	private Result checkIfCityisValid(Long cityId) {
		if(cityId<=0) {
			return new ErrorResult("??ehir bo?? b??rak??lamaz!");
		}
		if(this.cityService.getById(cityId).getData()==null) {
			return new ErrorResult("B??yle bir ??ehir yok!");
		}
		return new SuccessResult();
	}

	private Result checkIfTotalJobTitle(int totalJobTitle) {
		if(totalJobTitle<=0) {
			return new ErrorResult("A????k pozisyon adedi bo?? b??rak??lamaz!");
		}
		return new SuccessResult();
	}
	

}
