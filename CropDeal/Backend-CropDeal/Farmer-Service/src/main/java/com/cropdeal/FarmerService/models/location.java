package com.cropdeal.FarmerService.models;

public class location {
	private String street;
	private String village;
	private String city;
	private String state;
	private String pincode;

	public location(String street, String village, String city, String state, String pincode) {
		super();
		this.street = street;
		this.village = village;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public location() {
		super();
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
