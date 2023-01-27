package com.garageplug.entities;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class CustomerDao {
	
	@Email
	private String emailId;

	private String firstName;
	
	private String lastName;
	
	@Pattern(regexp = "[0-9]{10}")
	private String phone;
		
	private String password;

	
	
	public CustomerDao() {
		super();
	}

	public CustomerDao(@Email String emailId, String firstName, String lastName,
			@Pattern(regexp = "[0-9]{10}") String phone, String password) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.password = password;
	}
	
	
	
	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
