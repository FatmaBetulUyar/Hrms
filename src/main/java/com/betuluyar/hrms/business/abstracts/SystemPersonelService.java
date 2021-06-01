package com.betuluyar.hrms.business.abstracts;

import java.util.List;

import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.SystemPersonel;

public interface SystemPersonelService {

	DataResult<List<SystemPersonel>> getAll();
	Result add(SystemPersonel systemPersonel);
}
