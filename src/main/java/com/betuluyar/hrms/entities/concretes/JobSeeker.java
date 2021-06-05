package com.betuluyar.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="jobseekers", uniqueConstraints={@UniqueConstraint(columnNames={"identity_number"})})
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class JobSeeker extends User {
	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="birth_date")
	private Date birthDate;
	


}
