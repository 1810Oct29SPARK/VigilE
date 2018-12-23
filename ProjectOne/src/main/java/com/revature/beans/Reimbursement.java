package com.revature.beans;

public class Reimbursement {


	public Reimbursement(int reimb_id, double amount, String description, Employee employee_id, Status stat,
			Employee reimb_resolver) {
		super();
		this.reimb_id = reimb_id;
		this.amount = amount;
		this.description = description;
		this.employee_id = employee_id;
		this.stat = stat;
		this.reimb_resolver = reimb_resolver;
	}
	private int reimb_id;
	private double amount;
	private String description;
	private Employee employee_id;
	private Status stat;
	private Employee reimb_resolver;
	public int getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
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
	public Employee getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Employee employee_id) {
		this.employee_id = employee_id;
	}
	public Status getStat() {
		return stat;
	}
	public void setStat(Status stat) {
		this.stat = stat;
	}
	public Employee getReimb_resolver() {
		return reimb_resolver;
	}
	public void setReimb_resolver(Employee reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimb_id=" + reimb_id + ", amount=" + amount + ", description=" + description
				+ ", employee_id=" + employee_id + ", stat=" + stat + ", reimb_resolver=" + reimb_resolver + "]";
	}
	
	
	

	
	
	
}
