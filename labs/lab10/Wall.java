package lab10;

import sedgewick.StdDraw;

public class Wall implements GameObject {

	private double x, y;
	private boolean hit;
	
	public Wall(double x) {
		this.x = x;
		this.y = 1.0;
		this.hit = false;
	}
	
	public double getX() {
		return x;
	}

	@Override
	public void setX(double x) {
		this.x = x;
		
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public boolean isHit() {
		return hit;
	}

	@Override
	public void setHit(boolean hit) {
		this.hit = hit;
	}

	@Override
	public void draw() {
		StdDraw.filledSquare(this.x, this.y, 0.1);
	}

	@Override
	public void move() {
		
	}

	@Override
	public void move(String s) {
		
	}
	
}
