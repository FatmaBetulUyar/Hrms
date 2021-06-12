package com.betuluyar.hrms.api.controllers;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;

import com.betuluyar.hrms.business.abstracts.CvService;
import com.betuluyar.hrms.business.abstracts.PhotoService;
import com.betuluyar.hrms.core.utilities.files.FileService;
import com.betuluyar.hrms.core.utilities.results.Result;
import com.betuluyar.hrms.entities.concretes.Cv;
import com.betuluyar.hrms.entities.concretes.Photo;

@RestController
@RequestMapping("/api/photos")
@CrossOrigin
public class PhotosController {
	
	private FileService cloudinaryService;
	private CvService cvService;
	private PhotoService photoService;


	@Autowired
	public PhotosController(FileService cloudinaryService,CvService cvService,PhotoService photoService) {
		super();
		this.cloudinaryService = cloudinaryService;
		this.cvService=cvService;
		this.photoService=photoService;
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody MultipartFile file, @RequestParam("id") long id) throws IOException {
		Photo photo=new Photo();
		Cv cv=new Cv();
		cv.setId(id);
		photo.setCv(cv);
		return this.photoService.add(photo, file);
	}
	
	/*
	 * @PostMapping("/upload") public ResponseEntity<Map> upload(@RequestParam
	 * MultipartFile multipartFile) throws IOException{ Map
	 * result=cloudinaryService.upload(multipartFile); return new
	 * ResponseEntity(result,HttpStatus.OK); }
	 */
	 
	
	/*
	 * @PostMapping(value = "/add") public Result add(@RequestParam(value = "id")
	 * long id, @RequestParam(value = "imageFile") MultipartFile imageFile){ Cv cv =
	 * this.cvService.getById(id).getData(); Photo photo = new Photo();
	 * photo.setCv(cv); return this.photoService.add(photo, imageFile); }
	 */

}
