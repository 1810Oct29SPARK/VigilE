package com.revature.beans;

public class Role {

	public Role(int id, String roleTitle) {
		super();
		this.id = id;
		this.roleTitle = roleTitle;
	}
	private int id;
	private String roleTitle;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleTitle() {
		return roleTitle;
	}
	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleTitle=" + roleTitle + "]";
	}
}
