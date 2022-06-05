package com.cropdeal.FarmerService.repository;

import org.springframework.context.annotation.Bean;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.cropdeal.FarmerService.models.UserModel;




public interface UserRepository extends MongoRepository<UserModel, String> {
	UserModel findByUsername(String username);
	
}