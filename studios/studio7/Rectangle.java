package studio7;

public class Rectangle {

	private double length, width;
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public Rectangle() {
		this(0, 0);
	}

	public double getLength() {
		return this.length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return this.width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getArea() {
		return getLength() * getWidth();
	}
	
	public double getPerimeter() {
		return 2 * (getLength() + getWidth());
	}
	
	public boolean smallerArea(Rectangle a) {
		if (getArea() >= a.getArea()) return false;
		else return true;
	}
	
	public boolean square() {
		if (getLength() == getWidth()) return true;
		else return false;
	}
	
}
