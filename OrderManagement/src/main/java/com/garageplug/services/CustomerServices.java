package com.garageplug.services;



import com.garageplug.entities.CustomerDao;
import com.garageplug.exceptions.UserCreationException;

public interface CustomerServices {
	
	public String RegisterUser(CustomerDao user) throws UserCreationException;
	

}
