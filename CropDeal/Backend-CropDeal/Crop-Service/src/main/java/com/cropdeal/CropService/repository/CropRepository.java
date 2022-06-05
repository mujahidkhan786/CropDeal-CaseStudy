package com.cropdeal.CropService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cropdeal.CropService.model.Crop;



public interface CropRepository extends MongoRepository<Crop, String> {

}