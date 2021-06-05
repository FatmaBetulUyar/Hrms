package com.betuluyar.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="verificationcodes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity()
public class VerificationCode {
	
	@Id
	@Column(name="user_id")
	private long userId;
	
	@Column(name="verification_code")
	private String verificationCode;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;

	public VerificationCode(long userId, String verificationCode) {
		super();
		this.userId = userId;
		this.verificationCode = verificationCode;
	}	
}
