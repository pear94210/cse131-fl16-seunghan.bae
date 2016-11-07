package exam2;

public class Box {

	private double width, length, height;
	private boolean open;
	
	public Box(double w, double l, double h) {
		this.width = w;
		this.length = l;
		this.height = h;
		this.open = true;
	}
	
	public String toString() {
		return "Box [" + this.width + "(w) * " + this.length + "(l) * " + this.height + "(h)]";
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getLength() {
		return this.length;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public boolean getOpen() {
		return this.open;
	}
	
	public void setOpen(boolean o) {
		this.open = o;
	}
	
	public double getVolume() {
		return (this.width * this.length * this.height);
	}
	
	public double getArea() {
		return (this.width * this.length);
	}
	
	public boolean insideFit(Box b) {
		if (b.getArea() >= this.getArea()) return false;
		else {
			if (b.getVolume() >= this.getVolume()) return false;
			else return true;
		}
	}
	
}
