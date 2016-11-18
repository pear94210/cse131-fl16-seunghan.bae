package lab10;

public interface GameObject {
	
	public double getX();
	
	public void setX(double x);
	
	public double getY();
	
	public void setY(double y);
	
	public boolean isHit();
	
	public void setHit(boolean hit);
	
	public void draw();
	
	public void move();

	void move(String s);
	
}
