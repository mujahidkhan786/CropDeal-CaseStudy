package com.casestudy.AdminService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.AdminService.models.Admin;

public interface AdminRepository extends MongoRepository<Admin, String> {

}
