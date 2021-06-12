package com.betuluyar.hrms.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.Photo;

public interface PhotoService {

	Result add(Photo photo, MultipartFile multipartFile) throws IOException;
	
}
