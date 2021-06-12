
	package com.betuluyar.hrms.core.utilities.files;

	import java.io.File;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.HashMap;
	import java.util.Map;

	import org.springframework.stereotype.Service;

	import org.springframework.web.multipart.MultipartFile;

import com.betuluyar.hrms.core.utilities.results.DataResult;
import com.betuluyar.hrms.core.utilities.results.SuccessDataResult;
import com.cloudinary.Cloudinary;
	import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryManager implements FileService{


		Cloudinary cloudinary;

		private Map<String, String > valuesMap=new HashMap<>();
		
		
		public CloudinaryManager() {
			valuesMap.put("cloud_name", "dpk3mqq9j");
			valuesMap.put("api_key", "391112424643576");
			valuesMap.put("api_secret", "cQs2AH1NZAHPTOLbrnhxC95QVNA");
			cloudinary=new Cloudinary(valuesMap);
		}
		
		// burda map yerine String url almanlazım:
		public DataResult<Map>  upload(MultipartFile multipartFile) throws IOException {
			File file =convert(multipartFile);
			Map result=cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			file.delete();
			return new SuccessDataResult<Map>(result) ;
		}
		
		
		public Map delete(String id) throws IOException {
			Map result=cloudinary.uploader().destroy(id, ObjectUtils.emptyMap());
			return result;
		}
		
		private File convert(MultipartFile multipartFile) throws IOException {
			File file=new File(multipartFile.getOriginalFilename());
			FileOutputStream fo=new FileOutputStream(file);
			fo.write(multipartFile.getBytes());
			fo.close();
			return file;
		}
		
		
	
}
