package com.garageplug.services;

import java.util.List;

import com.garageplug.entities.CustomerDao;
import com.garageplug.entities.DiscountCoupon;
import com.garageplug.exceptions.OrderException;
import com.garageplug.exceptions.UserCreationException;

public interface CustomerServices {
	
	public String RegisterUser(CustomerDao user) throws UserCreationException;
	
	public List<DiscountCoupon> DiscountedCopun(String emailId) throws UserCreationException, OrderException;
	

}
