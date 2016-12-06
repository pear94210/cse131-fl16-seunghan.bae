package project;

import sedgewick.StdDraw;

public class Obstacle implements Moveable {

	private double posX;
	private double posY;
	private double width;
	private double height;
	private int hits;
	
	/**
	 * Create an Obstacle object to be implemented in the game
	 */
	public Obstacle() {
		this.posX = 0;
		this.posY = -.25;
		this.width = .61;
		this.height = .1;
		this.hits = 0;
	}
	
	/**
	 * 
	 * @return posX- x-coordinate of obstacle (center)
	 */
	public double getPosX() {
		return this.posX;
	}
	
	/**
	 * 
	 * @return posY- y-coordinate of obstacle (center)
	 */
	public double getPosY() {
		return this.posY;
	}
	
	/**
	 * 
	 * @return length of the obstacle
	 */
	public double getWidth() {
		return this.width;
	}
	
	/**
	 * 
	 * @return number of hits the player has
	 */
	public int getHits() {
		return this.hits;
	}
	
	/**
	 * Draw obstacle
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(this.posX, this.posY, this.width/2, this.height/2);
	}
	
	/**
	 * Move obstacle (We don't need to do anything here since obstacle doesn't move)
	 */
	public void move() {
		
	}
	
	/**
	 * Kill obstacle by shrinking width
	 */
	public void die() {
		this.hits++;
		this.width -= 0.2;
	}
	
	/**
	 * Reset obstacle to its original width and hits
	 */
	public void reset() {
		this.width = .61;
		this.hits = 0;
	}
	
	/**
	 * Determine if the obstacle and bullet collide based on comparing upper left and bottom right coordinates of each
	 * @param b- bullet that obstacle potentially collided with
	 * @return true if collision occurred
	 */
	public boolean collide(Bullet b) {
		double myTopLeftX = posX - width/2;
		double myTopLeftY = posY + height/2;
		double myBottomRightX = posX + width/2;
		double myBottomRightY = posY - height/2;
		
		double otherTopLeftX = b.getPosX() - b.getSize()/2;
		double otherTopLeftY = b.getPosY() + b.getSize()/2;
		double otherBottomRightX = b.getPosX() + b.getSize()/2;
		double otherBottomRightY = b.getPosY() - b.getSize()/2;
		
		return (myTopLeftY >= otherBottomRightY && myBottomRightY <= otherTopLeftY && myBottomRightX >= otherTopLeftX && myTopLeftX <= otherBottomRightX);
	}
	
}
