package com.betuluyar.hrms.entities.concretes;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cvs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="github_adress")
	private String githubAdress;
	
	@Column(name="linkedin_adress")
	private String linkedinAdress;
	
	/*
	 * @Column(name="photo") private String photo;
	 */
	
	@Column(name="technologies")
	private String technologies;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	
	
	@ManyToOne
	@JoinColumn(name="jobseeker_id")
	@JsonIgnore
	private JobSeeker jobSeeker;
	
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<School> schools; 
	
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<JobExperience> jobExperinces; 
	
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnore
	private List<ForeignLanguage> foreignLanguages; 
	
	
	@OneToOne(mappedBy = "cv")
	private Photo photo;
	
	
	
	
	
	
}
