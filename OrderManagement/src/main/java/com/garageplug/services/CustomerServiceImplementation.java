package com.garageplug.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garageplug.entities.Customer;
import com.garageplug.entities.CustomerDao;
import com.garageplug.entities.DiscountCoupon;
import com.garageplug.entities.Order;
import com.garageplug.exceptions.OrderException;
import com.garageplug.exceptions.UserCreationException;
import com.garageplug.repository.CustomerRepository;
import com.garageplug.repository.OrderRepository;


@Service
public class CustomerServiceImplementation implements CustomerServices{
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public String RegisterUser(CustomerDao user) throws UserCreationException {
		
		Optional<Customer> optional = customerRepo.findById(user.getEmailId());
		
		if(optional.isPresent())
			throw new UserCreationException("User already present");
		
		Customer customer = new Customer();
		
		customer.setCustomerType("Regular");
		customer.setEmail(user.getEmailId());
		customer.setFirstName(user.getFirstName());
		customer.setLastName(user.getLastName());
		customer.setPhone(user.getPhone());
		customer.setPassword(user.getPassword());
		
		customerRepo.save(customer);
		
		return "User Registered Successfully";
	}

	@Override
	public List<DiscountCoupon> DiscountedCopun(String emailId) throws UserCreationException, OrderException {
		
        Optional<Customer> optional = customerRepo.findById(emailId);
		
        
		if(optional.isPresent()) {
			
			Customer existingCustomer = optional.get();
			
			List<Order> orderList = orderRepo.findByEmailAndCustomerType(emailId, existingCustomer.getCustomerType());
			
			if(orderList.isEmpty())
				throw new OrderException("No discount coupon available");
			
			List<DiscountCoupon> couponList = new ArrayList<>();
			
			for(Order order : orderList) {
				
				DiscountCoupon coupon = new DiscountCoupon();
				coupon.setOrderId(order.getId());
				coupon.setDiscountValue(order.getDiscountAmount()+"%");
				couponList.add(coupon);
				
			}
			
		}
		
		
		throw new UserCreationException("No user found with emailId "+emailId);
			
	}

}
