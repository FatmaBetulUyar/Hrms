package com.betuluyar.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="foreignlanguages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForeignLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="language_name")
	private String languageName;
	
	@Column(name="level")
	private int level;
	
	@ManyToOne()
	@JoinColumn(name = "cv_id")
	@JsonIgnore
	private Cv cv;
}
