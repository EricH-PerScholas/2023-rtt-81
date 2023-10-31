package org.perscholas.database.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.Customer;

public class CustomerDAO {

	// the desired behavior is ... return a single Customer object OR return null
	// null is indicating that it was not found
	public Customer findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Customer c WHERE c.id = :id"; // Example of HQL to get all records of user class

		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("id", id);

		try {
			Customer result = query.getSingleResult();
			session.close();
			return result;
		} catch (NoResultException nre) {
			return null;
		}
	}
	
	public Customer updateFirstName(Integer id, String firstName) {
		Customer save = findById(id);
		
		save.setContactFirstname(firstName);

		return save(save);
	}
	

	// by contrast a method that returns a list will ALWAYS return a list
	// this kind of method never returns null
	// if there are no records the list will empty
	public List<Customer> findByFirstName(String fname) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// Example of HQL to get all records of user class
		// SQL is : select * from customers c where c.contact_firstname = :firstname and
		// c.contact_lastname = :lastname
		String hql = "FROM Customer c WHERE c.contactFirstname = :firstname";

		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("firstname", fname);

		List<Customer> result = query.getResultList();
		session.close();
		
		return result;
	}

	public Customer save(Customer save) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

//		if ( save.getId() == null ) {
//			session.save(save);
//		} else {
//			session.merge(save);
//		}

		session.saveOrUpdate(save);
		t.commit();
		session.close();
		
		return save;
	}

}
