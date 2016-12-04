package project;

import sedgewick.StdDraw;

public class Alien implements Moveable {
	
	private double posX;
	private double posY;
	private final double startX;
	private final double startY;
	private final double width = 0.15;
	private final double height = 0.15;
	private double speed;	
	private boolean upDown;
	private boolean isAlive = true;
	private boolean mothership;
	
	/**
	 * Creates an Alien object to be implemented in the game
	 * @param x- x-coordinate of alien (center)
	 * @param y- y-coordinate of alien (center)
	 * @param speed- speed at which the alien moves 
	 * @param upDown- true if alien moves up/down pattern; false if alien moves side-to-side pattern
	 * @param mothership- true if mothership; false if normal alien
	 */
	public Alien(double x, double y, double speed, boolean upDown, boolean mothership) {
		this.posX = x;
		this.posY = y;
		this.startX = x;
		this.startY = y;
		this.speed = -speed;
		this.upDown = upDown;
		this.mothership = mothership;
	}
	
	/**
	 * 
	 * @return posX- x-coordinate of alien (center)
	 */
	public double getPosX() {
		return this.posX;
	}
	
	/**
	 * 
	 * @return posY- y-coordinate of alien (center)
	 */
	public double getPosY() {
		return this.posY;
	}
	
	/**
	 * 
	 * @return width- width of alien
	 */
	public double getWidth() {
		return this.width;
	}
	
	/**
	 * 
	 * @return height- height of alien
	 */
	public double getHeight() {
		return this.height;
	}
	
	/**
	 * 
	 * @return true if mothership; false if normal alien
	 */
	public boolean getMothership() {
		return this.mothership;
	}
	
	/**
	 * draw alien
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.WHITE);
		if (mothership) StdDraw.filledCircle(this.posX, this.posY, this.width/2);
		else StdDraw.filledRectangle(this.posX, this.posY, this.width/2, this.height/2);
	}
	
	/**
	 * move alien
	 */
	public void move() {
		if (isOffScreen()) {
			speed *= -1;
		}
		if (upDown) {
			this.posY += speed;
		} else {
			this.posX += speed;
		}

	}
	/**
	 * 
	 * @return whether alien is off-screen
	 */
	public boolean isOffScreen() {
		return (this.posX > 1 || this.posX < -1 || this.posY > 1 || this.posY < -1);
	}
	
	/**
	 * move alien to start position
	 */
	public void moveToStart() {
		this.posX = startX;
		this.posY = startY;
	}
	
	/**
	 * 
	 * @return true if alien is alive
	 */
	public boolean isAlive() {
		return this.isAlive;
	}
	
	/**
	 * make alien die
	 */
	public void die() {
		this.isAlive = false;
	}
	

}
