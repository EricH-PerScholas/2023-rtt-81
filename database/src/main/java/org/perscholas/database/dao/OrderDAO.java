package org.perscholas.database.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.Order;

public class OrderDAO {

	public Order findById(Integer id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Order o WHERE o.id = :id"; // Example of HQL to get all records of user class

		TypedQuery<Order> query = session.createQuery(hql, Order.class);
		query.setParameter("id", id);

		try {
			Order result = query.getSingleResult();
			session.close();
			
			return result;
		} catch (NoResultException nre) {
			return null;
		}
	
	}
	
	public List<Order> findByCustomerId(Integer customerId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// Example of HQL to get all records of user class
		// SQL is : select * from customers c where c.contact_firstname = :firstname and
		// c.contact_lastname = :lastname
		String hql = "FROM Order o WHERE o.customerId = :customerId";

		TypedQuery<Order> query = session.createQuery(hql, Order.class);
		query.setParameter("customerId", customerId);

		List<Order> result = query.getResultList();
		session.close();
		
		return result;
	}
	
	
	public void save(Order order) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

//		if ( save.getId() == null ) {
//			session.save(save);
//		} else {
//			session.merge(save);
//		}

		session.saveOrUpdate(order);
		t.commit();
		session.close();
	}
	
}
