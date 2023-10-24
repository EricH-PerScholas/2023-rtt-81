package org.perscholas.database;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.perscholas.database.dao.OrderDAO;
import org.perscholas.database.entity.Customer;
import org.perscholas.database.entity.Order;

public class CreateOrderExample {

	private OrderDAO orderDao = new OrderDAO();
	
	
	
	public void createOrder() throws ParseException {
		Order order = new Order();
		
		// makes a new date object that represents right now
		Date orderDate = new Date();
		order.setOrderDate(orderDate);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date requredDate = sdf.parse("2023-10-31 12:30");
		
		// this is the # of miliseconds since the epoch
		System.out.println(orderDate.getTime());
		
		order.setRequiredDate(requredDate);
		
		// here we are setting the shipped date to  null because the order has not 
		// yet shipped
		order.setShippedDate(null);
		
		
	}
	
	public void queryOrder() {
		Order o = orderDao.findById(10100);
		
		Customer c = o.getCustomer();
		
		System.out.println("Order " + o.getId() + " was made by customer " + c.getCustomerName() + " on " + o.getOrderDate());
		
		// all the customers orders
		List<Order> orders = c.getOrders();
		for ( Order order : orders ) { 
			System.out.println("Order " + order.getId());
		}
	}
	
	
	public static void main(String[] args) {
		CreateOrderExample x = new CreateOrderExample();
		try {
			//x.createOrder();
			x.queryOrder();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
