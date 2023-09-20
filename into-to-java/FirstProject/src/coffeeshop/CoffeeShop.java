package coffeeshop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {
	
	// this of this as the menu the coffee shop has to offer
	List<Product> products = new ArrayList<>();
	
	public void setupProducts() {
		Product coffee = new Product();
		coffee.setName("Coffee");
		coffee.setPrice(5.44);
		products.add(coffee);
		
		Product tea = new Product();
		tea.setName("Tea");
		tea.setPrice(4.33);
		products.add(tea);
		
		Product cookie = new Product();
		cookie.setName("Cookie");
		cookie.setPrice(6.77);
		products.add(cookie);
		
		printAllProducts();
	}
	
	public void printProduct(Product product) { 
		System.out.println("Product name : " + 
				product.getName() + " Price : " 
				+ product.getPrice());	
	}
	
	public void printAllProducts() {
		for (Product product : products ) {
			printProduct(product);
		}
	}
	

	public static void main(String[] args) {
		CoffeeShop cf = new CoffeeShop();
		cf.setupProducts();
		
		
		// the value in each product is the price
		double coffee = 5.44d;
		double tea = 4.33d;
		double cookie = 6.73d;
		
		double subTotal = 0;
		
		// 3 items of the first product
		subTotal = coffee * 1;
		
		// 4 items of the 2nd product
		subTotal = subTotal + (tea * 1);
		
		// 2 items of the 3rd product
		subTotal = subTotal + (cookie * 1);
		
		DecimalFormat df = new DecimalFormat("#,##0.00");	
		System.out.println("Subtotal\t" + df.format(subTotal));
		
		double salesTax = subTotal * 0.10;
		System.out.println("Sales Tax\t" + df.format(salesTax));
		
		double totalSale = subTotal + salesTax;
		System.out.println("Total\t\t" + df.format(totalSale));
		
	}
}
