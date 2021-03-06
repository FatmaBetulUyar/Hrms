package com.betuluyar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.JobSeeker;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long>{

	
	JobSeeker findByIdentityNumber(String identityNumber);
	JobSeeker getByEmail(String email);
}
