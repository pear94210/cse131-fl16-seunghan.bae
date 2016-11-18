package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Player implements GameObject{

	private double x, y;
	private boolean hit;
	
	public Player() {
		this.x = 0.0;
		this.y = 0.0;
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
		StdDraw.filledCircle(this.getX(), this.getY(), 0.25);
	}
	
	public void move() {
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.filledCircle(this.getX(), this.getY(), 0.27);
		
		if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_LEFT)) this.setX(this.getX() - 0.25);
		if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_RIGHT)) this.setX(this.getX() + 0.25);
		
		if (this.getX() > 5.0) this.setX(this.getX() - 0.25);
		if (this.getX() < -5.0) this.setX(this.getX() + 0.25);

		this.draw();
		StdDraw.show(50);
	}
	
	public void shoot() {
		if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_UP)) {
			Bullet b = new Bullet(this.x, this.y + 0.32);
			b.draw();
			while (b.getY() <= 11) {
				b.move("player");
			}
		}
	}

	@Override
	public void move(String s) {
		
	}

}
