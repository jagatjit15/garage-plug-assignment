package com.garageplug.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.garageplug.entities.CustomerDao;
import com.garageplug.services.CustomerServices;
import com.garageplug.services.OrderServices;

@RestController
@RequestMapping("/garageplug/users")
public class UserController {
	
	@Autowired
	private CustomerServices customerService;
	
	@Autowired
	private OrderServices orderService;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> userRegistrationHandler(@Valid @RequestBody CustomerDao customer){
		
		String response = customerService.registerUser(customer);
		
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
		
	}
	
	
	
	@PostMapping("/cart")
	public ResponseEntity<String> OrderConfirmedHandler(@Valid @RequestParam("emailId") String emailId){
		
		String response = orderService.Checkout(emailId);
		
		return new ResponseEntity<String>(response, HttpStatus.ACCEPTED);
		
	}
	

}
