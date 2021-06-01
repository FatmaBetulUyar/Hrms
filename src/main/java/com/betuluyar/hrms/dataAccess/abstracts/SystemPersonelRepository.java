package com.betuluyar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betuluyar.hrms.entities.concretes.SystemPersonel;

@Repository
public interface SystemPersonelRepository extends JpaRepository<SystemPersonel, Long>{

}
