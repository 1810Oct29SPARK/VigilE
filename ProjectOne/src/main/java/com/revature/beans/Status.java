package com.revature.beans;

public class Status {

	public Status(int id, String statusWord) {
		super();
		this.id = id;
		this.statusWord = statusWord;
	}
	private int id;
	private String statusWord;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatusWord() {
		return statusWord;
	}
	public void setStatusWord(String statusWord) {
		this.statusWord = statusWord;
	}
	@Override
	public String toString() {
		return "Status [id=" + id + ", statusWord=" + statusWord + "]";
	}
	
}
