package com.cropdeal.FarmerService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class UserModel {
	@Id
	private String id;
	private String username;
	private String password;
	public UserModel() {
		
	}
	
	public String getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRole(String role) {
		// TODO Auto-generated method stub
		
	}
	
}
