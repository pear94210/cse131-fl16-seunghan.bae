package lab10;

public interface GameObject {
	
	public double getX();
	
	public void setX(double x);
	
	public double getY();
	
	public void setY(double y);
	
	public double getSize();
	
	public void setSize(double size);
	
	public void draw();
	
	public void move();
	
	public void hit();
	
}
