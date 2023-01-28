package com.garageplug.services;


import java.time.LocalDateTime;
import java.util.List;

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
		
		Customer existingCustomer = customerRepo.findByEmail(emailId);
		
		if(existingCustomer != null) {
			
			
			Order order = new Order();
			
			if(existingCustomer.getOrderCount() == null)
				existingCustomer.setOrderCount(1);
			
			else
				existingCustomer.setOrderCount(existingCustomer.getOrderCount() + 1);
			
			placeOrder(order, existingCustomer);
			
			if(existingCustomer.getOrderCount() >= 6 && existingCustomer.getOrderCount() < 10)
				return "Order Placed! Purchase "+(10 - existingCustomer.getOrderCount())+" more to become GOLD customer"
						+ " and get 10% off";
			
			else if(existingCustomer.getOrderCount() == 10)
				return "GOLD Level achieved";
			
			else if(existingCustomer.getOrderCount() >= 16 && existingCustomer.getOrderCount() < 20)
				return "Order Placed! Purchase "+(20 - existingCustomer.getOrderCount())+" more to become PLATINUM customer"
						+ " and get 20% off";
			
			else if(existingCustomer.getOrderCount() == 20)
				return "PLATINUM Level achieved";
			
			else
				return "Order Placed!";
			
		}
		
		throw new UserCreationException("No User found with emailId "+ emailId);
		
	}
	
	

	private void placeOrder(Order order, Customer customer) {
		
		if(customer.getOrderCount() == 10)
			customer.setCustomerType("Gold");
		
		if(customer.getOrderCount() == 20)
			customer.setCustomerType("Platinum");
		
		if(customer.getOrderCount() >= 10 && customer.getOrderCount() < 20)
			order.setDiscountAmount(10);
		
		if(customer.getOrderCount() >= 20)
			order.setDiscountAmount(20);
		
		order.setCustomer(customer);
		order.setOrderDate(LocalDateTime.now());
		List<Order> list = customer.getOrders();
		list.add(order);
		customer.setOrders(list);
		
		orderRepo.save(order);
		
	}

}
