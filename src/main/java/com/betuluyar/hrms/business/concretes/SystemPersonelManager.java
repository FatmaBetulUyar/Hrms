package com.betuluyar.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betuluyar.hrms.business.abstracts.SystemPersonelService;
import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.core.utilities.results.SuccessDataResult;
import com.betuluyar.hrms.core.utilities.results.SuccessResult;
import com.betuluyar.hrms.dataAccess.abstracts.SystemPersonelRepository;
import com.betuluyar.hrms.entities.concretes.SystemPersonel;

@Service
public class SystemPersonelManager implements SystemPersonelService {

	private SystemPersonelRepository systemPersonelRepository;
	
	
	@Autowired
	public SystemPersonelManager(SystemPersonelRepository systemPersonelRepository) {
		super();
		this.systemPersonelRepository = systemPersonelRepository;
	}

	@Override
	public DataResult<List<SystemPersonel>> getAll() {
		
		return new SuccessDataResult<List<SystemPersonel>>(systemPersonelRepository.findAll(), "Sistem personelleri listelendi");
	}

	@Override
	public Result add(SystemPersonel systemPersonel) {
		this.systemPersonelRepository.save(systemPersonel);
		return new SuccessResult("Sistem Personeli eklendi");
	}

}
