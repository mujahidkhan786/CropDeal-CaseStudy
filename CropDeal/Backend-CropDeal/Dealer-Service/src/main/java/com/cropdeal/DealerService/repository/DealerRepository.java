package com.cropdeal.DealerService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cropdeal.DealerService.model.Dealer;



public interface DealerRepository extends MongoRepository<Dealer, String> {

}