package org.perscholas.database;

import java.util.List;

import org.perscholas.database.dao.CustomerDAO;
import org.perscholas.database.entity.Customer;

public class HibernateExample {

	public static void main(String[] args) {
		CustomerDAO customerDao = new CustomerDAO();

		Customer customer = customerDao.findById(103);

		System.out.println(customer.getId() + " | " + customer.getCustomerName());
		
		
		List<Customer> customers = customerDao.findByFirstName("Leslie");
		for ( Customer c : customers ) {
			System.out.println(c.getId() + " | " + c.getCustomerName() + " | " + c.getContactFirstname() + " | " + c.getContactLastname());
		}
		
	}

}
