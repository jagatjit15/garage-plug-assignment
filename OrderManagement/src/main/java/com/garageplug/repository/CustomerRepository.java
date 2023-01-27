package com.garageplug.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garageplug.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{
	
	public Customer findByEmail(String email);
	

}