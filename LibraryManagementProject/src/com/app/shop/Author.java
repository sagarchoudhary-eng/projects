package com.app.shop;

public class Author {
	String name;
	String emailId;

	public Author(String name, String emailId) {
		super();
		this.name = name;
		this.emailId = emailId;
	}
	

	@Override
	public String toString() {
		return "Author [name=" + name + ", emailId=" + emailId + "]";
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
