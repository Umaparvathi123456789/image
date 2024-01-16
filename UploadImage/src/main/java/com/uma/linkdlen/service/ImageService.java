package com.uma.linkdlen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uma.linkdlen.entity.Image;
import com.uma.linkdlen.repo.ImageRepository;

@Service
public class ImageService {
	@Autowired
	private ImageRepository repo;

	public Image saveData(Image image) {
	 Image savedImage=repo.save(image);
	 return savedImage;
	}

	public List<Image> getAllUsers() {
		return repo.findAll();
	}

	public void deleteUser(Integer id) {
		repo.deleteById(id);		
	}
}
