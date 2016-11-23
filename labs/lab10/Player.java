package lab10;

import sedgewick.StdDraw;

public class Player implements GameObject{

	private double x, y;
	private double size;
	private int life;
	
	public Player() {
		this.x = 0.0;
		this.y = 0.0;
		this.size = 0.25;
		this.life = 3;
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
	
	public int getLife() {
		return life;
	}
	
	public void setLife(int life) {
		this.life = life;
	}
	
	public void draw() {
		StdDraw.filledCircle(this.x, this.y, this.size);
	}
	
	public void move() {		
		if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_LEFT)) this.x = this.x - 0.2;
		if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_RIGHT)) this.x = this.x + 0.2;
		
		if (this.getX() > 5.0) this.setX(this.getX() - 0.2);
		if (this.getX() < -5.0) this.setX(this.getX() + 0.2);
	}
	
	public void hit() {
		this.life--;
	}
	
	public Bullet shoot() {
		return new Bullet(this.x, this.y + this.size + 0.05, true);
	}

}
