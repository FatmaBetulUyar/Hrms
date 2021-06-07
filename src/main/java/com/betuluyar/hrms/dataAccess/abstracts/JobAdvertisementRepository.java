package com.betuluyar.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betuluyar.hrms.entities.concretes.JobAdvertisement;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Long>{

	List<JobAdvertisement> findByOrderByReleaseDate();
}