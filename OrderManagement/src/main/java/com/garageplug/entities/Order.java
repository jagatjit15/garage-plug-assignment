package com.garageplug.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Orders")
public class Order {
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    private Customer customer;

    private LocalDateTime orderDate;
    
    private Integer discountAmount;
    
    
//    Constructors
    
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}



public Order(Long id, Customer customer, LocalDateTime orderDate, Integer discountAmount) {
	super();
	this.id = id;
	this.customer = customer;
	this.orderDate = orderDate;
	this.discountAmount = discountAmount;
}







//	getter and setter

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public LocalDateTime getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}




	public Integer getDiscountAmount() {
		return discountAmount;
	}




	public void setDiscountAmount(Integer discountAmount) {
		this.discountAmount = discountAmount;
	}


	

    
    
    
    
}
