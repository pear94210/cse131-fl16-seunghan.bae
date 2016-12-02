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
	private double alienSpeed;
	private int score;
	
	public Game() {
		aliens = new LinkedList<Alien>();
		move = new LinkedList<Moveable>();
		bullets = new LinkedList<Bullet>();
		StdDraw.setScale(-1, 1);
		player = new Player(0, -.9, .04, 3);
		move.add(player);
		alienSpeed = 0.04;
		addAliens();
		score = 0;
	}
	
	public void drawBoard(int score) {
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0, 0, 1, 1);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(0.75, 0.9, "Score: " + score);
	}
	
	public boolean isOver() {
		return (!(player.getLives() > 0));
	}
	
	public void addAliens(){
		addAlien(0.5, 0.5, alienSpeed, true);
		addAlien(-0.5, 0.5, alienSpeed, true);
		addAlien(-0.9, 0.5, alienSpeed, false);
	}
	
	private void addAlien(double x, double y, double speed, boolean upDown)
	{
		Alien a = new Alien(x, y, speed, upDown);
		aliens.add(a);
		move.add(a);
	}
	
	public void play(){
		// Draw game board with score shown + draw players & aliens and make them move
		drawBoard(score);
		for (Moveable m : move) {
			m.move();
			m.draw();
		}
		
		// If player fires and there are less than 3 bullets outstanding, create new bullet and make it move
		if (player.fire() && bullets.size() < 3) {
			Bullet b = new Bullet(player.getPosX(), player.getPosY() + .15, .05);
			move.add(b);
			bullets.add(b);
		}
		
		// Code for collision between player-alien and alien-bullet + bullet going out of the board
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
					score += 50;
				}
				else if (b.getPosY() >= 1){
					b.setOffScreen();
				}
			}
		}
		/*CODE A*/ //end
		
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
	
	public void levelUp() {
		if (aliens.isEmpty()) {
			alienSpeed *= 1.5;
			addAliens();
		}
	}
	
	public void drawGameEnd()
	{
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(0, 0, 1, 1);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(0, 0, "GAME OVER");
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
