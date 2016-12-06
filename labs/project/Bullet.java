package project;

import sedgewick.StdDraw;

public class Bullet implements Moveable{
	
	private double posX;
	private double posY; 
	private double size = 0.05;
	private double speed;
	private boolean isOffScreen = false;
	
	/**
	 * Create a Bullet object to be implemented in the game
	 * @param x- x-coordinate of bullet (center)
	 * @param y- y-coordinate of bullet (center)
	 * @param speed- speed at which the bullet moves 
	 */
	public Bullet(double x, double y, double speed) {
		this.posX = x;
		this.posY = y;
		this.speed = speed;
	}
	
	/**
	 * 
	 * @return posX- x-coordinate of bullet (center)
	 */
	public double getPosX() {
		return this.posX;
	}
	
	/**
	 * 
	 * @return posY- y-coordinate of bullet (center)
	 */
	public double getPosY() {
		return this.posY;
	}
	
	/**
	 * 
	 * @return size- size of bullet
	 */
	public double getSize() {
		return this.size;
	}
	
	/**
	 * Determine if bullet is out of bounds
	 */
	public boolean getIsOffScreen() {
		return this.isOffScreen;	
	}
	
	/**
	 * Make the bullet off-screen
	 */
	public void setOffScreen() {
		this.isOffScreen = true;
	}
	
	/**
	 * Draw bullet
	 */
	public void draw() {
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledSquare(this.posX, this.posY, this.size/2);
	}
	
	/**
	 * Move bullet
	 */
	public void move() {
		this.posY += speed;
	}
	
	/**
	 * Determine if a bullet and alien collide based on comparing upper left and bottom right coordinates of each
	 * @param a- alien that bullet potentially collided with
	 * @return true if collision occurred
	 */
	public boolean collide(Alien a) {	
		double myTopLeftX = posX - size/2;
		double myTopLeftY = posY + size/2;
		double myBottomRightX = posX + size/2;
		double myBottomRightY = posY - size/2;
		
		double otherTopLeftX = a.getPosX() - a.getSize()/2;
		double otherTopLeftY = a.getPosY() + a.getSize()/2;
		double otherBottomRightX = a.getPosX() + a.getSize()/2;
		double otherBottomRightY = a.getPosY() - a.getSize()/2;
		
		return (myTopLeftY >= otherBottomRightY && myBottomRightY <= otherTopLeftY && myBottomRightX >= otherTopLeftX && myTopLeftX <= otherBottomRightX);
	}

}
