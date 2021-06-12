package com.betuluyar.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.betuluyar.hrms.entities.concretes.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

	List<School> getByOrderByGraduationDateDesc();
	
}
