package lab10;

public class Player {

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
	
	
	
}
