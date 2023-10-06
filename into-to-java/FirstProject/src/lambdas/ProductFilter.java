package lambdas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import coffeeshop.Product;

public class ProductFilter {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();

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
		products.add(1, water);

		List<Product> cheap = new ArrayList<>();
		for (Product product : products) {
			if (product.getPrice() < 6.0) {
				cheap.add(product);
			}
		}
		
		List<Product> streamCheap = products.stream().filter(product -> product.getPrice() < 6.0)
				.collect(Collectors.toList());
		
		// this is nice to be able to sort a list quickly in few lines of code
		List<Product> sortedList = products.stream()
				  .sorted(Comparator.comparing(Product::getName))
				  .collect(Collectors.toList());
	}

}
