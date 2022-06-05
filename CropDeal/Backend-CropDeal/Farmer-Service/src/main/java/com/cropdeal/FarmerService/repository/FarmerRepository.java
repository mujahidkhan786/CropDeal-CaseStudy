package com.cropdeal.FarmerService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cropdeal.FarmerService.models.Farmer;


public interface FarmerRepository extends MongoRepository<Farmer, String> {

}