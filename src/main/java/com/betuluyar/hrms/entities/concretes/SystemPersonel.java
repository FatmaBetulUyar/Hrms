package com.betuluyar.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Entity
@Table(name="systempersonels")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class SystemPersonel extends User{
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	
	
}
