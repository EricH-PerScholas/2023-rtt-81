package org.perscholas.springboot.database.dao;


import org.junit.jupiter.api.*;
import org.perscholas.springboot.database.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerDAOTest {

    @Autowired
    private CustomerDAO customerDAO;

    @Test
    @Order(1)
    public void createCustomerTest() {
        // given
        Customer customer = new Customer();
        customer.setFirstName("Test First 12345");
        customer.setLastName("Test Last");
        customer.setCity("Test City");
        customer.setPhone("Test Phone");
        customer.setImageUrl("image url");

        // when
        customer = customerDAO.save(customer);

        // then
        Assertions.assertNotNull(customer.getId());
        Assertions.assertEquals("Test First 12345", customer.getFirstName());
        Assertions.assertEquals("Test Last", customer.getLastName());
        Assertions.assertEquals("Test City", customer.getCity());
        Assertions.assertEquals("Test Phone", customer.getPhone());
        Assertions.assertEquals("image url", customer.getImageUrl());
        Assertions.assertNull(customer.getUser());
    }

    @Test
    @Order(2)
    public void findByFirstNameOrLastNameTest() {
        // given
        String firstName = "Test First 12345";

        // when
        List<Customer> customers = customerDAO.findByFirstNameOrLastName(firstName, null);

        // then
        Assertions.assertEquals(1, customers.size());

        Customer customer = customers.get(0);
        Assertions.assertNotNull(customer.getId());
        Assertions.assertEquals("Test First 12345", customer.getFirstName());
        Assertions.assertEquals("Test Last", customer.getLastName());
        Assertions.assertEquals("Test City", customer.getCity());
        Assertions.assertEquals("Test Phone", customer.getPhone());
        Assertions.assertEquals("image url", customer.getImageUrl());
        Assertions.assertNull(customer.getUser());
    }

    @Test
    @Order(3)
    public void deleteCustomerTest() {
        // given
        String firstName = "Test First 12345";

        // when
        int deleted = customerDAO.deleteByFirstName(firstName);

        // then
        Assertions.assertEquals(1, deleted);
    }

    @Test
    @Order(4)
    public void shouldNotExistTest() {
        // given
        String firstName = "Test First 12345";

        // when
        List<Customer> customers = customerDAO.findByFirstNameOrLastName(firstName, null);

        // then
        Assertions.assertEquals(0, customers.size());
    }

}
