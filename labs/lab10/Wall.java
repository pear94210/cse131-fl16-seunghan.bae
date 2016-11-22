package lab10;

import sedgewick.StdDraw;

public class Wall implements GameObject {

	private double x, y;
	private double size;
	
	public Wall(double x, double y) {
		this.x = x;
		this.y = y;
		this.size = 0.1;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
		
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;		
	}

	public void draw() {
		StdDraw.filledSquare(this.x, this.y, 0.1);
	}

	public void move() {
		
	}
	
	public void hit() {
		this.x = 100;
		this.y = 100;
		this.size = 0;
	}
	
}
