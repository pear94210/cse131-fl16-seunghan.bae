package project;

import java.awt.Color;
import java.util.Iterator;
import java.util.LinkedList;

import sedgewick.StdDraw;

/**
 * Plays game by using all created objects and Moveable interface
 * @author Zachary Polsky
 *
 */

public class Game {
	
	private LinkedList<Alien> aliens;
	private LinkedList<Moveable> move;
	private LinkedList<Bullet> bullets;
	private Player player;
	private Obstacle obstacle;
	private double alienSpeed;
	private int score;
	
	/**
	 * Create a Space Invader game
	 */
	public Game() {
		aliens = new LinkedList<Alien>();
		move = new LinkedList<Moveable>();
		bullets = new LinkedList<Bullet>();
		StdDraw.setScale(-1, 1);
		player = new Player(0, -.9, .04, 3);
		move.add(player);
		obstacle = new Obstacle();
		move.add(obstacle);
		alienSpeed = 0.04;
		addAliens();
		score = 0;
	}
	
	/**
	 * Draw game background
	 * @param score- player's score
	 */
	public void drawBoard(int score) {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0, 0, 1, 1);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(.75, .9, "Score: " + score);
	}
	
	/**
	 * 
	 * @return true if player's life becomes zero (game is over)
	 */
	public boolean isOver() {
		return (!(player.getLives() > 0));
	}
	
	/**
	 * Add three aliens + a mothership (using addAlien)
	 */
	public void addAliens(){
		addAlien(.5, .5, alienSpeed, true, false);
		addAlien(-.5, .5, alienSpeed, true, false);
		addAlien(-.9, .25, alienSpeed, false, false);
		addAlien(-.9, .75, 2 * alienSpeed, false, true);
	}
	
	/**
	 * Add alien to 'aliens' and 'move' list
	 * @param x- x-coordinate of alien (center)
	 * @param y- y-coordinate of alien (center)
	 * @param speed- speed at which the alien moves 
	 * @param upDown- true if alien moves up/down pattern; false if alien moves side-to-side pattern
	 * @param mothership- true if mothership; false if normal alien
	 */
	private void addAlien(double x, double y, double speed, boolean upDown, boolean mothership)
	{
		Alien a = new Alien(x, y, speed, upDown, mothership);
		aliens.add(a);
		move.add(a);
	}
	
	/**
	 * run game
	 */
	public void play(){
		// Draw game board with score shown + draw player & aliens and make them move
		drawBoard(score);
		for (Moveable m : move) {
			m.move();
			m.draw();
		}
		
		// If player fires and there less than 3 bullets outstanding, create new bullet and make it move
		if (player.fire() && bullets.size() < 3) {
			Bullet b1 = new Bullet(player.getPosX(), player.getPosY() + .15, .05);
			move.add(b1);
			bullets.add(b1);
		}
		
		// Code for collision between player-alien & alien-bullet
		/*CODE A*/ // start
		for (Alien a : aliens) {
			if (player.collide(a)) {
				player.die();
				score -= 10;
			}
			for (Bullet b : bullets) {
				if (b.collide(a)) {
					a.die();
					b.setOffScreen();
					if (a.getMothership()) score += 100;
					else score += 50;
				}
				else if (b.getPosY() >= 1){
					b.setOffScreen();
				}
			}
		}
		/*CODE A*/ //end
		
		// Code for collision between obstacle-bullet
		for (Bullet b : bullets) {
			if (obstacle.collide(b)) {
				obstacle.die();
				b.setOffScreen();
				if (obstacle.getHits() > 0 && obstacle.getHits() % 3 == 0) move.remove(obstacle);
			}
			else if (b.getPosY() >= 1){
				b.setOffScreen();
			}
		}
		
		// Used to prevent concurrent modification errors
		Iterator<Alien> alienIter = aliens.iterator();
		while (alienIter.hasNext()) {
		    Alien a = alienIter.next();
		    if (!a.isAlive()) {
		    	alienIter.remove();
		    	move.remove(a);
		    }
		}
		
		Iterator<Bullet> bulletIter = bullets.iterator();
		while (bulletIter.hasNext()) {
		    Bullet b = bulletIter.next();
		    if (b.getIsOffScreen()) {
		    	bulletIter.remove();
		    	move.remove(b);
		    }
		}
		
		// player levels up according to the levelUp() method, or if game is over, draw "GAME OVER" screen
		levelUp();
		StdDraw.show(60);
		
		if (isOver()){
			drawGameEnd();
		}
	}
	
	/**
	 * Level up the stage when all aliens are killed + reset aliens & obstacle
	 */
	public void levelUp() {
		if (aliens.isEmpty()) {
			alienSpeed *= 1.5;
			addAliens();
			obstacle.reset();
			move.add(obstacle);
		}
	}
	
	/**
	 * Draw the 'game over' screen with score shown
	 */
	public void drawGameEnd()
	{
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0, 0, 1, 1);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(0, .1, "GAME OVER");
		StdDraw.text(0, -.1, "Score: " + score);
		StdDraw.show(100);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		while (!game.isOver()){
			game.play();
		}
	}

}
