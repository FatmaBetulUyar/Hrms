package com.betuluyar.hrms.core.business.utilities;

import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;

public class BusinessRules {
public static Result run(Result... logics) {
		
		for (Result result : logics) {
			if(!result.isSuccess()) {
				return result;
			}
		}
		return null;
	}
}
