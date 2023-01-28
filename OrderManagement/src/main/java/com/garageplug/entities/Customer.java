package com.garageplug.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


//This is the entity class for storing user data about personal data and order history in the database
// The Customer Entity and Order entity have One to Many relation between them.

@Entity
@Table(name = "Customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	
	private String firstName;
	
	private String lastName;
	
	@JsonIgnore
	private String customerType;
	
	private String email;
	
    private String phone;
	
	private String password;
    
	private Integer orderCount;
	
	@OneToMany(mappedBy = "customer")
	@JsonIgnore
	private List<Order> orders = new ArrayList<>();
	
	
	
//	Constructor
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


public Customer(Long customerId, String firstName, String lastName, String customerType, String email, String phone,
		String password, Integer orderCount, List<Order> orders) {
	super();
	this.customerId = customerId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.customerType = customerType;
	this.email = email;
	this.phone = phone;
	this.password = password;
	this.orderCount = orderCount;
	this.orders = orders;
}



//	getter and setter
	
//	....................
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	
//	....................
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
//	....................

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	
//	....................
	
	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	
//	....................
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
//	....................

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
//	....................

	public Integer getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	public List<Order> getOrders() {
		return orders;
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

		

}
