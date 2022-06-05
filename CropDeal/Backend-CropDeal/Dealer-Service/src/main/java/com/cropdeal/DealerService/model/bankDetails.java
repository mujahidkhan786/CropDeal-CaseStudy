package com.cropdeal.DealerService.model;

public class bankDetails {

	private String account_number;
	private String bank_name;
	private String IFSC_code;

	public bankDetails() {
		super();
	}

	public bankDetails(String account_number, String bank_name, String IFSC_code) {
		super();
		this.account_number = account_number;
		this.bank_name = bank_name;
		this.IFSC_code = IFSC_code;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getIFSC_code() {
		return IFSC_code;
	}

	public void setIFSC_code(String IFSC_code) {
		this.IFSC_code = IFSC_code;
	}

}

