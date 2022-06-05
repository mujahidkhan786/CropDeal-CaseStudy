package com.casestudy.AdminService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class UserModel {
	@Id
	private String id;
	private String name;
	private String username;
	private String password;
	private String city;
	private String role;
	public UserModel() {
		
	}

	public UserModel(String id,String name, String username, String password, String city, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.city=city;
		this.role = role;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
