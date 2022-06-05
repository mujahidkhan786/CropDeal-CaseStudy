package com.casestudy.AdminService.models;

public class AuthenticationResponse {
	private String reponse;
	
	public AuthenticationResponse() {
		
	}
	public AuthenticationResponse(String reponse) {
		super();
		this.reponse = reponse;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
}
