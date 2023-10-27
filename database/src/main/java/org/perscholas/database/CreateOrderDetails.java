package org.perscholas.database;

import java.util.List;
import java.util.Scanner;

import org.perscholas.database.dao.OrderDAO;
import org.perscholas.database.dao.OrderDetailsDAO;
import org.perscholas.database.dao.ProductDAO;
import org.perscholas.database.entity.Order;
import org.perscholas.database.entity.OrderDetail;
import org.perscholas.database.entity.Product;

public class CreateOrderDetails {

	private OrderDAO orderDAO = new OrderDAO();
	private ProductDAO productDAO = new ProductDAO();
	private OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAO();

	
	public void createOrderDetails() {
		// ask the user to enter a product name
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a product name to add to your order:");
		String productName = scanner.nextLine();
		
		// looks up a product by a productName
		// TODO make the product name work with like .. so I Can enter a partial product name
		// whill have to google getting like to work with hibernate
		// and get back a list of "Ford" products
		List<Product> products = productDAO.findByName(productName);
		
		// this will display the products on the screen
		if ( products.size() == 0 ) {
			System.out.println("You did not enter a valid proper product name");
			System.exit(0);
		}
		
		// the query for product name can return more that one product with the same name
		// so we list the products that were returned 
		for ( Product product : products ) {
			System.out.println("Product id " + product.getId() + " | " + product.getProductName());
		}
		
		// of the list of of product names that we show let the user select the id that they want to add
		System.out.println("Select a product Id:");
		Integer productId = scanner.nextInt();
		
		// the goal is to insert a record into the order details table
		Product p = productDAO.findById(productId);
		
		// TODO this should another check here to make sure that they product loaded is a product
		if ( p == null ) {
			System.out.println("You have entered an invalid product id.");
			System.exit(1);
		}
		
		// TODO add the ability to ask the user for an order number
		// ask the user what order number they want to add the product too
		System.out.println("Enter an order number to add a product to:");
		Integer orderId = scanner.nextInt();
		Order o = orderDAO.findById(orderId);
		
		// TODO
		// if the order is null then print a message saying invalid order number
		if ( o == null ) {
			System.out.println("You have entered an invalid order id.");
			System.exit(1);
		}

		// TODO .... if the product is already part of the order details - 
		// print a message saying you can not add a duplicate product
		// its its not part of the order then add it to the order
		for ( OrderDetail orderDetail : o.getOrderDetails() ) {
			if ( p.getId().equals(orderDetail.getProduct().getId())) {
				System.out.println("This product is already part of the order.");
				//System.exit(1);
			}
		}
		
		// because this returned not null we know that the product is already part of the order.
		OrderDetail queryOd = orderDetailsDAO.findByOrderIdAndProductId(orderId, productId);
		System.out.println("============> should not be null "+ queryOd);
		if ( queryOd != null ) {
			// here I would increment the quantity ordered
			System.out.println("This product is already part of the order.");
			System.exit(1);
		} else {

			OrderDetail od = new OrderDetail();
			od.setProduct(p);
			od.setOrder(o);
			od.setOrderLineNumber(200);
			od.setPriceEach(5.55);
			od.setQuantutyOrdered(300);
			
			orderDetailsDAO.save(od);
			
			System.out.println("Successfully added product to order");
		}
		
		
	}
	
	
	public static void main(String[] args) {
		CreateOrderDetails cod = new CreateOrderDetails();
		cod.createOrderDetails();	
	}
	
	
}
