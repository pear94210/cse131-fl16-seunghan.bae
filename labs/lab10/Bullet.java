package lab10;

import sedgewick.StdDraw;

public class Bullet implements GameObject{

	private double x, y;
	private double size;
	private boolean direction;
	
	public Bullet(double x, double y, boolean d) {
		this.x = x;
		this.y = y;
		this.size = 0.04;
		this.direction = d;
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
	
	public boolean getDirection() {
		return direction;
	}
	
	public void setDirection(boolean d) {
		this.direction = d;
	}
	
	public void draw() {
		StdDraw.filledCircle(this.x, this.y, this.size);
	}
	
	public void move() {		
		if (this.direction) this.y = this.y + 0.25;
		else this.y = this.y - 0.25;
	}
	
	public void hit() {
		this.x = 100;
		this.y = 100;
		this.size = 0;
	}
	
}
