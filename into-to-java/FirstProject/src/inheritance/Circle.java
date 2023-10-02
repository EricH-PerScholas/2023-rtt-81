package inheritance;

public class Circle extends Shape {

	private double diameter;

	// this functionality is only for a circle
	// because a rectangle does not have a radius
	// or a diameter
	public double getRadius() {
		return diameter / 2;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	@Override
	public double calculateArea() {
		// TODO Auto-generated method stub
		return PI * getDiameter() * getDiameter();
	}

	@Override
	public double calculateParimiter() {
		return (PI * 2) * getRadius();
	}

}
