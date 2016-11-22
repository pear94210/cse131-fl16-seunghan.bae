package lab10;

import sedgewick.StdDraw;

public class Alien implements GameObject{

	private double x, y;
	private double size;
	private boolean direction;
	
	public Alien(double x, double y) {
		this.x = x;
		this.y = y;
		this.size = 0.25;
		this.direction = true;
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
		StdDraw.filledSquare(this.x, this.y, this.size);
	}
	
	public void move() {
		if (this.direction) this.x = this.x + 0.01;
		else this.x = this.x - 0.01;
	}

	public void hit() {
		this.x = -100;
		this.y = -100;
		this.size = 0;		
	}

	public Bullet shoot() {
		return new Bullet(this.x, this.y - this.size - 0.05, false);
	}
	
}
