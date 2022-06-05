package com.casestudy.AdminService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@ToString

@Document(collection = "Dealer")
public class Dealer {

	@Id
	private String id;
	private String dealer_name;
	private String dealer_email;
	private String dealer_contactNo;
	private String password;

	private bankDetails bank_detail;


	public Dealer() {
		super();
	}

	

	public Dealer(String id, String dealer_name, String dealer_email, String dealer_contactNo, String password,
			bankDetails bank_detail) {
		super();
		this.id = id;
		this.dealer_name = dealer_name;
		this.dealer_email = dealer_email;
		this.dealer_contactNo = dealer_contactNo;
		this.password = password;
		this.bank_detail = bank_detail;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDealer_name() {
		return dealer_name;
	}

	public void setDealer_name(String dealer_name) {
		this.dealer_name = dealer_name;
	}

	public String getDealer_email() {
		return dealer_email;
	}

	public void setDealer_email(String dealer_email) {
		this.dealer_email = dealer_email;
	}

	public String getDealer_contactNo() {
		return dealer_contactNo;
	}

	public void setDealer_contactNo(String dealer_contactNo) {
		this.dealer_contactNo = dealer_contactNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public bankDetails getBank_detail() {
		return bank_detail;
	}

	public void setBank_detail(bankDetails bank_detail) {
		this.bank_detail = bank_detail;
	}



}
