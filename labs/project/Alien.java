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
	
	/**
	 * Creates an Alien object to be implemented in the game
	 * @param x- x-coordinate of alien (center)
	 * @param y- y-coordinate of alien (center)
	 * @param speed- speed at which the alien moves 
	 * @param upDown- true if alien moves up/down pattern; false if alien moves side-to-side pattern
	 */
	public Alien(double x, double y, double speed, boolean upDown) {
		this.posX = x;
		this.posY = y;
		this.startX = x;
		this.startY = y;
		this.speed = -speed;
		this.upDown = upDown;
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
	 * draw alien
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(this.posX, this.posY, this.width/2, this.height/2);
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
	 * @return whether alien is alive
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
