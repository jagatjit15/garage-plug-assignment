package com.garageplug;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.garageplug.entities.Customer;
import com.garageplug.entities.CustomerDao;
import com.garageplug.exceptions.UserCreationException;
import com.garageplug.repository.CustomerRepository;
import com.garageplug.services.CustomerServiceImplementation;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplementationTest {

    @Mock
    private CustomerRepository customerRepo;

    @InjectMocks
    private CustomerServiceImplementation customerService;

    private CustomerDao customerDao;

    @Before
    public void setUp() {
        customerDao = new CustomerDao();
        customerDao.setEmailId("test@email.com");
        customerDao.setFirstName("Test");
        customerDao.setLastName("User");
        customerDao.setPhone("1234567890");
        customerDao.setPassword("password");
    }

    @Test
    public void testRegisterUser_Success() throws UserCreationException {
        when(customerRepo.findByEmail("test@email.com")).thenReturn(null);
        String result = customerService.registerUser(customerDao);
        assertEquals("User Registered Successfully [ UserId = null ]", result);
    }

    @Test
    public void testRegisterUser_UserAlreadyExists() throws UserCreationException {
        when(customerRepo.findByEmail("test@email.com")).thenReturn(new Customer());
        assertThrows(UserCreationException.class, () -> customerService.registerUser(customerDao));
    }
}
