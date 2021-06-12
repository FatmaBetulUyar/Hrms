package com.betuluyar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betuluyar.hrms.entities.concretes.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

	Photo getByCv_id(Long id);
}
