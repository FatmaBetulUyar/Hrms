package com.betuluyar.hrms.core.utilities.files;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.betuluyar.hrms.core.utilities.results.DataResult;

public interface FileService {
	public DataResult<Map>  upload(MultipartFile multipartFile) throws IOException;

}
