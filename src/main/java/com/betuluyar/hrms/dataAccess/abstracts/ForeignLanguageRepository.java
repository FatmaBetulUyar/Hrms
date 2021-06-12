package com.betuluyar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.betuluyar.hrms.entities.concretes.ForeignLanguage;

@Repository
public interface ForeignLanguageRepository extends JpaRepository<ForeignLanguage, Long>{

}
