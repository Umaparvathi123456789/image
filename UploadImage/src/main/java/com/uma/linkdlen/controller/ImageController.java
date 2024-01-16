package com.uma.linkdlen.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uma.linkdlen.entity.Image;
import com.uma.linkdlen.service.ImageService;

@RestController
public class ImageController {
	@Autowired
	private ImageService service;
	public static String uploadDirectory=System.getProperty("user.dir")+ "/src/main/webapp/images";
	
	@GetMapping("/")
	public String home() {
		return "Welcome to image uploading using spring boot";
	}
	@GetMapping("/image/details")
	public List<Image> getAllUsers(){
		return service.getAllUsers();
	}
	@PostMapping("/save/image")
	public Image saveImage(@ModelAttribute Image image, @RequestParam("file") MultipartFile file) throws IOException {
	String originalFileName=file.getOriginalFilename();
	Path fileNameAndPath=Paths.get(uploadDirectory,originalFileName);
	Files.write(fileNameAndPath, file.getBytes());
	image.setImage(originalFileName);
		Image savedData=service.saveData(image);
		return savedData;	}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
	 service.deleteUser(id);
	return ResponseEntity.noContent().build();
}}
