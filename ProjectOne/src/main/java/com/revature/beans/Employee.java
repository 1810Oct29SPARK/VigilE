package com.revature.beans;

public class Employee {

	public Employee(int id, String firstName, String lastName, String email, int role_id, String username,
			String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role_id = role_id;
		this.username = username;
		this.password = password;
	}
	
	
	public Employee() {
		
	}
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private int role_id;
	private String username;
	private String password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", role_id=" + role_id + ", username=" + username + ", password=" + password + "]";
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getRole_id() {
		return role_id;
	}


	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
}
