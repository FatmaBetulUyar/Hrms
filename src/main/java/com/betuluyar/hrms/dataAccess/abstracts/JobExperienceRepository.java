package com.betuluyar.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betuluyar.hrms.entities.concretes.JobExperience;

@Repository
public interface JobExperienceRepository extends JpaRepository<JobExperience, Long>{

	List<JobExperience> getByOrderByEndDateDesc();
	
}
