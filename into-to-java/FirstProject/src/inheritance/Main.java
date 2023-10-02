package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// area = l * w
		Rectangle rect = new Rectangle();
		rect.setName("Rectangle");
		rect.setHeight(10);
		rect.setWidth(5);
		
		Area a = (Area)rect;
		Shape s = (Shape)rect;

		
		// area = pi * r * r
		Circle circle = new Circle();
		circle.setName("Circle");
		circle.setDiameter(100);
		circle.getRadius();

		
		List<Shape> shapes = new ArrayList<>();
		shapes.add(rect);
		shapes.add(circle);
		
		for ( Shape shape : shapes ) {
			if (shape instanceof Circle) {
				// do something 
				Circle c = (Circle)shape;
				c.getRadius();
			}
			
			double x = 10.3;
			int y = (int)x;
			
			
			
			System.out.println("The area for shape " + shape.getName() + " is " + shape.calculateArea());
			System.out.println("The parimiter for shape " + shape.getName() + " is " + shape.calculateParimiter());
		}
		
	}

}
