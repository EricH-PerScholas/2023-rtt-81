package coffeeshop;

public class Product {

	public static String CONSTANT = "Constant";
	
	private String name;
	private double price;
	
	public Product() {
		
	}
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
