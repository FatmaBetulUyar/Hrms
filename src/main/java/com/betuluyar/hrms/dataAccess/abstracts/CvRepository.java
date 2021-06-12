package com.betuluyar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.betuluyar.hrms.entities.concretes.Cv;
import com.betuluyar.hrms.entities.concretes.dto.CvDto;

@Repository
public interface CvRepository extends JpaRepository<Cv, Long>{

	/*
	 * @Query("Select new com.betuluyar.hrms.entities.concretes.dto.CvDto(c.id,c.githubAddress,c.linkedinAddress,c.coverLetter,c.photo,j) From Cv c JOIN c.jobSeeker j Where c.id=:id"
	 * ) CvDto findCvWithDetailsById(Long id);
	 */
}
