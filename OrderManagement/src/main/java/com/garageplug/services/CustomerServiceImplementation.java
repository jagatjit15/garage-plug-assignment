package com.garageplug.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garageplug.entities.Customer;
import com.garageplug.entities.CustomerDao;
import com.garageplug.exceptions.UserCreationException;
import com.garageplug.repository.CustomerRepository;


@Service
public class CustomerServiceImplementation implements CustomerServices{
	
	@Autowired
	private CustomerRepository customerRepo;
	

	@Override
	public String registerUser(CustomerDao user) throws UserCreationException {
		
		Customer existingCustomer = customerRepo.findByEmail(user.getEmailId());
		
		if(existingCustomer != null)
			throw new UserCreationException("User already present");
		
		Customer customer = new Customer();
		
		customer.setCustomerType("Regular");
		customer.setEmail(user.getEmailId());
		customer.setFirstName(user.getFirstName());
		customer.setLastName(user.getLastName());
		customer.setPhone(user.getPhone());
		customer.setPassword(user.getPassword());
		
		customerRepo.save(customer);
		
		return "User Registered Successfully"+" [ UserId = "+ customer.getCustomerId()+" ]";
	}

}
