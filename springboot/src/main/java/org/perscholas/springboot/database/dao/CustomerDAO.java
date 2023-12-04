package org.perscholas.springboot.database.dao;

import org.perscholas.springboot.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long> {

    public Customer findById(Integer id);

    @Query("SELECT c FROM Customer c WHERE c.firstName LIKE :firstName or c.lastName LIKE :lastName")
    List<Customer> findByFirstNameOrLastName(String firstName, String lastName);


}
