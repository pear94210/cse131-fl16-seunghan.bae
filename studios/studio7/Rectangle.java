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
	
	/**
	 * 
	 * @return length of rectangle
	 */
	public double getLength() {
		return this.length;
	}
	
	/**
	 * 
	 * @param length
	 */
	public void setLength(double length) {
		this.length = length;
	}
	
	/**
	 * 
	 * @return width of rectangle
	 */
	public double getWidth() {
		return this.width;
	}
	
	/**
	 * 
	 * @param width
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	
	/**
	 * 
	 * @return area of rectangle
	 */
	public double getArea() {
		return getLength() * getWidth();
	}
	
	/**
	 * 
	 * @return perimeter of rectangle
	 */
	public double getPerimeter() {
		return 2 * (getLength() + getWidth());
	}
	
	/**
	 * 
	 * @param a (rectangle to be compared with)
	 * @return true if rectangle is smaller than a
	 */
	public boolean smallerArea(Rectangle a) {
		if (getArea() >= a.getArea()) return false;
		else return true;
	}
	
	/**
	 * 
	 * @return true if rectangle is square
	 */
	public boolean square() {
		if (getLength() == getWidth()) return true;
		else return false;
	}
	
}
