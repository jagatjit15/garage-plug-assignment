package com.garageplug.services;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garageplug.entities.Customer;
import com.garageplug.entities.Order;
import com.garageplug.exceptions.OrderException;
import com.garageplug.exceptions.UserCreationException;
import com.garageplug.repository.CustomerRepository;
import com.garageplug.repository.OrderRepository;

@Service
public class OrderServicesImplementation implements OrderServices{
	
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private OrderRepository orderRepo;

	

	@Override
	public String Checkout(String emailId) throws UserCreationException, OrderException {
		
		Optional<Customer> optional = customerRepo.findById(emailId);
		
		if(optional.isPresent()) {
			
			Customer customer = optional.get();
			
			Order order = new Order();
			
			customer.setOrderCount(customer.getOrderList().size() + 1);
			order.setCustomer(customer);
			order.setOrderDate(LocalDateTime.now());
			
			List<Order> list = customer.getOrderList();
			list.add(order);
			customer.setOrderList(list);
			
			orderRepo.save(order);
			
			
			if(customer.getOrderCount() >= 0 && customer.getOrderCount() < 10) {
				
				return "Order "+ (10 - customer.getOrderList().size()) +" More to Become Gold Customer";
				
			}
			
			else if(customer.getOrderCount() == 10) {
				
				return "You are a Gold Customer now";
				
			}
			
           else if(customer.getOrderCount() > 10 && customer.getOrderCount() < 20) {
				
        	   return "Order "+ (20 - customer.getOrderList().size()) +" More to Become Platinum Customer";
				
			}
			
           else if(customer.getOrderCount() == 20){
        	   return "You are a Gold Customer now";
           }
			
           else
        	   return "Visit again. Thank You!";
			
		}
		
		throw new UserCreationException("No User found with emailId "+ emailId);
		
	}

}
