package com.betuluyar.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.betuluyar.hrms.entities.concretes.JobAdvertisement;



@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Long>{

	List<JobAdvertisement> findByOrderByReleaseDate();
	
	
	JobAdvertisement findByIdAndEmployer_Id(long id, long employerId);
	
	List<JobAdvertisement> getByIsActive(Boolean isActive);
	
	
	@Query("From JobAdvertisement where isActive=:isActive and employer.id=:id")
	List<JobAdvertisement> getByIsActiveAndEmployer(Boolean isActive, long id);
	
	
	List<JobAdvertisement> getByIsActiveAndId(Boolean isActive, long id);
}
