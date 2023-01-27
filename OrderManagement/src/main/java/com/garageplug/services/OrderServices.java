package com.garageplug.services;

import com.garageplug.exceptions.OrderException;
import com.garageplug.exceptions.UserCreationException;

public interface OrderServices {
	
	public String Checkout(String emailId) throws UserCreationException, OrderException;
	
	

}
