package com.betuluyar.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="jobadvertisements")
public class JobAdvertisement {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//@NotBlank(message = "İş tanımı boş bırakılamaz!")
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="is_active")
	private boolean isActive;
	
	//@NotBlank(message = "Açık pozisyon adedi boş bırakılamaz!")
	@Column(name="total_jobtitle")
	private int totalJobTitle;
	
	@Column(name="release_date")
	private Date releaseDate;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	//@NotBlank(message = "İş pozisyonu seçilmesi zorunludur.")
	@ManyToOne
	@JoinColumn(name="jobtitle_id")
	private JobTitle jobTitle;
	
	//@NotBlank(message = "Şehir seçilmesi zorunludur.")
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="city_id")
	private City city;
	
	
	//@NotBlank(message = "Şirket seçilmesi zorunludur.")
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
}
