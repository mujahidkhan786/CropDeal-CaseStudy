package com.casestudy.AdminService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@ToString

@Document(collection ="Admin")
public class Admin {
	@Id
	private String id;
	
	private String username;
	private String password;

	public Admin() {
		
	}

	public Admin(String id, String username ,String password) {
		super();
		this.id = id;
		
		this.password = password;
		this.username=username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}