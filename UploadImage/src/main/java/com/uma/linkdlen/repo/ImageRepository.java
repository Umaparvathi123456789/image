package com.uma.linkdlen.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uma.linkdlen.entity.Image;
@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>{

}
