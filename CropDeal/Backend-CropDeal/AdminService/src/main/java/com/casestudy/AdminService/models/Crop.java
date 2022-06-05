package com.casestudy.AdminService.models;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Crop")
public class Crop {

	@Id
	private String id;
	private String crop_name;
	private String crop_type;
	private String crop_quantity;
	private location location;
	private String uploaded_by;

	public Crop(String id, String crop_name, String crop_type, String crop_quantity, String uploaded_by) {
		super();
		this.id = id;
		this.crop_name = crop_name;
		this.crop_type = crop_type;
		this.crop_quantity = crop_quantity;

		this.uploaded_by = uploaded_by;
	}

	public String getUploaded_by() {
		return uploaded_by;
	}

	public void setUploaded_by(String uploaded_by) {
		this.uploaded_by = uploaded_by;
	}

	public Crop(String id, String crop_name, String crop_type, String crop_quantity, location loc) {
		super();
		this.id = id;
		this.crop_name = crop_name;
		this.crop_type = crop_type;
		this.crop_quantity = crop_quantity;
		this.location = loc;
	}

	public String getCrop_quantity() {
		return crop_quantity;
	}

	public void setCrop_quantity(String crop_quantity) {
		this.crop_quantity = crop_quantity;
	}

	public location getLoc() {
		return location;
	}

	public void setLoc(location loc) {
		this.location = loc;
	}

	public Crop() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCrop_name() {
		return crop_name;
	}

	public void setCrop_name(String crop_name) {
		this.crop_name = crop_name;
	}

	public String getCrop_type() {
		return crop_type;
	}

	public void setCrop_type(String crop_type) {
		this.crop_type = crop_type;
	}

}
