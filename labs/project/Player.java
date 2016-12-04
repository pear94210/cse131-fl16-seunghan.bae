package project;

import java.awt.Color;

import sedgewick.StdDraw;

public class Player implements Moveable {
	
	private double posX;
	private double posY; 
	private final double startPosX;
	private final double startPosY;
	private final double size = 0.1;
	private Color color;
	private int lives;
	private double speed;
	private final Color [] colors = {StdDraw.RED, StdDraw.YELLOW, StdDraw.WHITE};
	
	/**
	 * Creates a Player object to be implemented in the game
	 * @param x- x-coordinate of player (center)
	 * @param y- y-coordinate of player (center)
	 * @param speed- speed at which the player moves 
	 * @param lives- number of lives the player starts with
	 */
	public Player(double x, double y, double speed, int lives) {
		this.posX = x;
		this.posY = y;
		this.startPosX = x;
		this.startPosY = y;
		this.speed = speed;
		this.lives = lives;
		this.color = colors[(this.lives-1) % 3];
	}
	
	/**
	 * 
	 * @return posX- x-coordinate of player (center)
	 */
	public double getPosX() {
		return this.posX;
	}
	
	/**
	 * 
	 * @return posY- y-coordinate of player (center)
	 */
	public double getPosY() {
		return this.posY;
	}
	
	/**
	 * 
	 * @return number of lives the player has
	 */
	public int getLives() {
		return this.lives;
	}
	
	/**
	 * Draw player
	 */
	public void draw() {
		StdDraw.setPenColor(this.color);
		StdDraw.filledSquare(this.posX, this.posY, this.size/2);
		StdDraw.filledRectangle(this.posX, (this.posY + this.size/1.5), this.size/6, this.size/2);
	}
	
	/**
	 * Move player
	 */
	public void move() {
		
		//If movements are possible:
		if ((ArcadeKeys.isKeyPressed(0, 1)) && (this.posX - this.speed > -1)) {
			this.posX -= this.speed;
		}
		else if ((ArcadeKeys.isKeyPressed(0, 3)) && (this.posX + this.speed < 1)) {
			this.posX += this.speed;
		}
	}
	
	/**
	 * 
	 * Fire bullet
	 */
	public boolean fire() {
		return (ArcadeKeys.isKeyPressed(0, 0)); //key w pushed
	}
	
	/**
	 * Kills player by reducing life and changing colors
	 */
	public void die() {
		this.lives--;
		if (lives != 0) {
			this.color = colors[lives - 1];
		}
		this.posX = this.startPosX;
		this.posY = this.startPosY; //doesn't do anything but good form
	}
	
	/**
	 * Determine if the player and alien collide based on comparing upper left and bottom right coordinates of each
	 * @param a- alien that player potentially collided with
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
