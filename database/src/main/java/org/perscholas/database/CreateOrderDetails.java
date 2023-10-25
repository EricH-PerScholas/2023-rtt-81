package org.perscholas.database;

import org.perscholas.database.dao.OrderDAO;
import org.perscholas.database.dao.ProductDAO;
import org.perscholas.database.entity.OrderDetail;

public class CreateOrderDetails {

	private OrderDAO orderDAO = new OrderDAO();
	private ProductDAO productDAO = new ProductDAO();

	
	public void createOrderDetails() {
		
	}
	
	
	public static void main(String[] args) {
		CreateOrderDetails cod = new CreateOrderDetails();
		cod.createOrderDetails();	
	}
	
	
}
