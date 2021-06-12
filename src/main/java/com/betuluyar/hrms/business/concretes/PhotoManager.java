
  package com.betuluyar.hrms.business.concretes;
  
  import java.io.IOException;
import java.util.Map;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Service; import
  org.springframework.web.multipart.MultipartFile;
  
  import com.betuluyar.hrms.business.abstracts.PhotoService; import
  com.betuluyar.hrms.core.utilities.files.FileService; import
  com.betuluyar.hrms.core.utilities.results.DataResult; import
  com.betuluyar.hrms.core.utilities.results.Result; import
  com.betuluyar.hrms.core.utilities.results.SuccessDataResult; import
  com.betuluyar.hrms.core.utilities.results.SuccessResult; import
  com.betuluyar.hrms.dataAccess.abstracts.PhotoRepository; import
  com.betuluyar.hrms.entities.concretes.Photo;
  
  @Service public class PhotoManager implements PhotoService{
  
  private PhotoRepository photoRepository;
  private FileService cloudinaryService;
  
  
  @Autowired 
  public PhotoManager(PhotoRepository photoRepository,FileService cloudinaryService ) 
  { 
	  super(); 
	  this.photoRepository = photoRepository;
	  this.cloudinaryService=cloudinaryService; 
  }
  
  
  @Override public Result add(Photo photo, MultipartFile multipartFile) throws IOException {
  
  @SuppressWarnings("unchecked")
  
  	Map<String,String> uploadPhoto=this.cloudinaryService.upload(multipartFile).getData();
  	photo.setPath(uploadPhoto.get("url"));
  	this.photoRepository.save(photo);
  	return new SuccessResult("Fotoğraf eklendi!");
  }



  
  
	/*
	 * @Override public DataResult<Photo> getByCvId(Long id) { return new
	 * SuccessDataResult<Photo>(this.photoRepository.getByCv_id(id)); }
	 */
  
  }
 
