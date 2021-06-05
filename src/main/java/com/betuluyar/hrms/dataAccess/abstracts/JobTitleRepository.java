package com.betuluyar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betuluyar.hrms.entities.concretes.JobTitle;

@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Integer>{
  
	JobTitle getByTitleName(String titleName);
}
