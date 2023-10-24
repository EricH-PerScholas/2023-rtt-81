package org.perscholas.database;

import java.util.List;

import org.perscholas.database.dao.CustomerDAO;
import org.perscholas.database.entity.Customer;

public class CreateAndUpdateExample {

	private CustomerDAO customerDao = new CustomerDAO();

	public void insertCustomerExample() {
		Customer c = new Customer();

		// when creating a new database record do not set the id on the entity
		c.setCustomerName("Series Reminder LLC");
		c.setContactFirstname("Eric");
		c.setContactLastname("Heilig");
		c.setAddressLine1("Address line 1");
		c.setAddressLine1("Address Line 2");
		c.setCity("Denver");
		c.setState("Colorado");
		c.setPostalCode("80203");
		c.setCountry("USA");
		c.setCreditLimit(10000.00);
		c.setPhone("555-555-1212");

		System.out.println("customer id before save " + c.getId());
		customerDao.save(c);

		// after you have have saved the entity, part of the save process updates the id
		System.out.println("customer id after save " + c.getId());
	}

	public void updateCustomerExample() {
		// make sure that a record with id 533 exists in your database
		Customer c = customerDao.findById(533);

		if (c != null) {
			System.out.println("Customer Name : " + c.getCustomerName());

			c.setContactFirstname("Updated Firstname");
			c.setContactLastname("Updated Lastname");
			c.setCreditLimit(44444.44);

			// we can set the FK but the FK number needs to exist in employees table or it
			// will error
			c.setSalesRepEmployeeId(1002);

			customerDao.save(c);
		} else {
			System.out.println("Customer does not exist");
		}
	}
	
	public void listQuery() {
		List<Customer> customers = customerDao.findByFirstName(null);
		System.out.println("We found " + customers.size() + " records in the database");
	}

	public static void main(String[] args) {
		CreateAndUpdateExample caue = new CreateAndUpdateExample();
		// caue.insertCustomerExample();
		// caue.updateCustomerExample();
		caue.listQuery();
	}
}
