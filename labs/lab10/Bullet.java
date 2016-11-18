package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Bullet implements GameObject{

	private double x, y;
	private boolean hit;
	
	public Bullet(double x, double y) {
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
		StdDraw.filledCircle(this.x, this.y, 0.05);
	}
	
	public void move(String s) {
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.filledCircle(this.x, this.y, 0.07);
		
		if (s == "player") this.y = this.y + 0.25;
		if (s == "alien") this.y = this.y - 0.25;
			
		this.draw();
		StdDraw.show(50);
	}

	@Override
	public void move() {
		
	}
}
