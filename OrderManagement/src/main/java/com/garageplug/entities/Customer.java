package com.garageplug.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Customers")
public class Customer {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	
	private String firstName;
	
	private String lastName;
	
	@JsonIgnore
	private String customerType;
	
	@Email
	@Id
	private String email;
	
	@Pattern(regexp = "[0-9]{10}")
    private String phone;
	
	private String password;
    
	private Integer orderCount;
	

	@OneToMany(cascade = CascadeType.MERGE , mappedBy = "customer")
	@JsonIgnore
	private List<Order> orderList = new ArrayList<>();
	
	
	
//	Constructor
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
public Customer(Long customerId, String firstName, String lastName, String customerType, @Email String email,
		@Pattern(regexp = "[0-9]{10}") String phone, String password, Integer orderCount, List<Order> orderList) {
	super();
	this.customerId = customerId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.customerType = customerType;
	this.email = email;
	this.phone = phone;
	this.password = password;
	this.orderCount = orderCount;
	this.orderList = orderList;
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



	public List<Order> getOrderList() {
		return orderList;
	}



	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	
	
	
	
	

}
