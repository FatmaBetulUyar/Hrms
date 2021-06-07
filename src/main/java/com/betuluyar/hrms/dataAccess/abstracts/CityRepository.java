package com.betuluyar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betuluyar.hrms.entities.concretes.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	City getById(Long id);

}
