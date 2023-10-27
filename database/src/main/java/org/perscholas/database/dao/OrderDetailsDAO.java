package org.perscholas.database.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.perscholas.database.entity.OrderDetail;
import org.perscholas.database.entity.Product;

public class OrderDetailsDAO {

	
	public OrderDetail findByOrderIdAndProductId(Integer orderId, Integer productId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM OrderDetail od WHERE od.order.id = :orderId and od.product.id = :productId"; // Example of HQL to get all records of user class

		TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
		query.setParameter("orderId", orderId);
		query.setParameter("productId", productId);

		try {
			OrderDetail result = query.getSingleResult();
			
			return result;
		} catch (NoResultException nre) {
			return null;
		}
	}
	
	
	public void save(OrderDetail orderDetail) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();
		session.saveOrUpdate(orderDetail);
		t.commit();
		session.close();
	}
	
}
