package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Alien implements GameObject{

	private double x, y;
	private boolean hit;
	
	public Alien(double x, double y) {
		this.x = x;
		this.y = y;
		this.hit = false;
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

	public boolean isHit() {
		return hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}
	
	public void draw() {
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledSquare(this.x, this.y, 0.25);
	}
	
	public void move(String s) {
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.filledSquare(this.x, this.y, 0.27);
		
		if (s == "left") this.x = this.x - 0.25;
		if (s == "right") this.x = this.x + 0.25;
		if (s == "up") this.y = this.y + 0.25;
		if (s == "down") this.y = this.y - 0.25;
		this.draw();
	}

	@Override
	public void move() {
				
	}
	
}
