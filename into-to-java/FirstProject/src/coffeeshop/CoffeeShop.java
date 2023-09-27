package coffeeshop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {

	// this of this as the menu the coffee shop has to offer
	List<Product> products = new ArrayList<>();

	// this is the list of items in your order
	List<Product> order = new ArrayList<>();

	// this is a class member variable to make it easier
	Scanner input = new Scanner(System.in);

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

		Product sandwich = new Product();
		sandwich.setName("Egg & Cheese Muffin");
		sandwich.setPrice(19.99);
		products.add(sandwich);
		
		Product water = new Product("Water", 5.99);
		products.add(1,water);
		
		//products.remove(0);
		//products.add(0,water);
	}

	public void printProduct(Product product) {
		// TODO HOMEWORK : Change this print only the product name + tab + price with a
		// $
		System.out.println("Product name : " + product.getName() + " Price : " + product.getPrice());
	}

	public void printAllProducts() {
		for (Product product : products) {
			printProduct(product);
		}
	}

	public void example() {
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

	public int displayMainUserMenu() {
		System.out.println("1) Print the menu items and prices");
		System.out.println("2) Add an item to your order");
		System.out.println("3) Print the itmes in your order");
		System.out.println("4) Checkout");
		System.out.println("5) Exit");

		System.out.print("\nWhat do you want to do? ");
		int select = input.nextInt();
		input.nextLine();

		return select;
	}

	public void userSelectProduct() {
		System.out.print("Enter product name to order: ");
		String orderSelection = input.nextLine();

		for (Product product : products) {
			if (product.getName().equalsIgnoreCase(orderSelection)) {
				order.add(product);
				System.out.println("Added " + product.getName() + " to your order.");
			}
		}
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public static void main(String[] args) {
		CoffeeShop cf = new CoffeeShop();
		cf.setupProducts();

		while (true) {
			int userSelection = cf.displayMainUserMenu();
			
			if (userSelection == 1) {
				cf.printAllProducts();
			} else if (userSelection == 2) {
				cf.userSelectProduct();
			} else if (userSelection == 3 ) {
				// TODO HOMEWOK - display the products in the order list here
			} else if ( userSelection == 5) {
				System.exit(0);
			} else {
				System.out.println("User input " + userSelection + " is unknonw.   Try again;");
			}
		}
	}
}
