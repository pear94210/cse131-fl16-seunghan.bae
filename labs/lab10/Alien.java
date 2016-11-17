package lab10;

public class Alien {

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
	
}
