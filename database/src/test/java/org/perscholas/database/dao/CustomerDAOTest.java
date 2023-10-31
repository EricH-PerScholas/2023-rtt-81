package org.perscholas.database.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.perscholas.database.entity.Customer;

public class CustomerDAOTest {

	@Test
	@Order(1)
	public void findByIdTest() {
		CustomerDAO customerDao = new CustomerDAO();
		
		Customer actual = customerDao.findById(112);
		
		// the first argument is the expected value
		// the second argument is the actual
		Assertions.assertEquals(112, actual.getId());
		Assertions.assertEquals("Signal Gift Stores", actual.getCustomerName());
		Assertions.assertEquals("Fisher", actual.getContactLastname());

	}
	
	@Test
	@Order(2)
	public void updateFirstNameTest() {
		CustomerDAO customerDao = new CustomerDAO();
		
		Customer actual = customerDao.updateFirstName(112, "Jessica");
		
		Assertions.assertEquals(112, actual.getId());
		Assertions.assertEquals("Signal Gift Stores", actual.getCustomerName());
		Assertions.assertEquals("Fisher", actual.getContactLastname());
		
		assertEquals("Jessica", actual.getContactFirstname());
		
	}
	
}
