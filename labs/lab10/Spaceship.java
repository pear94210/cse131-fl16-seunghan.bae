package lab10;

import sedgewick.StdDraw;

public class Spaceship implements GameObject{

	private double x, y;
	private double size;
	private boolean direction;
	
	public Spaceship(boolean direction) {
		if (direction == true) this.x = -6;
		else this.x = 6;
		
		this.y = 10;
		this.size = 0.5;
		this.direction = direction;
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
		double[] xs = {this.x, this.x + this.size, this.x - this.size};
		double[] ys = {this.y, this.y - this.size, this.y - this.size};
		StdDraw.filledPolygon(xs, ys);;
	}

	public void move() {
		if (this.direction) this.x = this.x + 0.075;
		else this.x = this.x - 0.075;
	}

	public void hit() {
		this.x = 0;
		this.y = -100;
		this.size = 0;
	}

}
