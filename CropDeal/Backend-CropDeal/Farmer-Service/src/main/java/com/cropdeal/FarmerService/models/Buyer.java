package com.cropdeal.FarmerService.models;

public class Buyer {
	private String buyer_name;
	private String buyer_contactNo;

	public Buyer(String buyer_name, String buyer_contactNo) {
		super();
		this.buyer_name = buyer_name;
		this.buyer_contactNo = buyer_contactNo;
	}

	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBuyer_name() {
		return buyer_name;
	}

	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}

	public String getBuyer_contactNo() {
		return buyer_contactNo;
	}

	public void setBuyer_contactNo(String buyer_contactNo) {
		this.buyer_contactNo = buyer_contactNo;
	}

}
