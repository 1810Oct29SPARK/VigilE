package com.revature.beans;

import java.util.Arrays;

public class Reimbursement {

	public Reimbursement(int r_id, double amount, String description, byte[] image, int e_id, String status,
			String resolver) {
		super();
		this.r_id = r_id;
		this.amount = amount;
		this.description = description;
		this.image = image;
		this.e_id = e_id;
		this.status = status;
		this.resolver = resolver;
	}
	private int r_id;
	private double amount;
	private String description;
	private byte[] image;
	private int e_id;
	private String status;
	private String resolver;
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResolver() {
		return resolver;
	}
	public void setResolver(String resolver) {
		this.resolver = resolver;
	}
	@Override
	public String toString() {
		return "Reimbursement [r_id=" + r_id + ", amount=" + amount + ", description=" + description + ", image="
				+ Arrays.toString(image) + ", e_id=" + e_id + ", status=" + status + ", resolver=" + resolver + "]";
	}
	
	
	
}
