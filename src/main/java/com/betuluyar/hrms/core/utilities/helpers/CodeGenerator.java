package com.betuluyar.hrms.core.utilities.helpers;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class CodeGenerator {

public String CodeGenerate() {
		
		UUID code=UUID.randomUUID();
		String verifyCode = code.toString(); 
	    return verifyCode;
	}
}
