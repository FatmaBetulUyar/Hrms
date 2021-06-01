package com.betuluyar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.betuluyar.hrms.entities.concretes.User;

@NoRepositoryBean
public interface UserRepository extends JpaRepository<User, Long> {

}
