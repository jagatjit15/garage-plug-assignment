package com.garageplug.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garageplug.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{
	
	public List<Order> findByEmailAndCustomerType(String email, String customerType);

}
