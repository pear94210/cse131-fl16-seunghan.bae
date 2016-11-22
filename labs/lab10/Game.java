package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Game {

	private Player player;
	private Alien[][] aliens;
	private int alienCount;
	private Bullet[] bullets;
	private int killCount;
	private Wall[][] walls;
	
	public Game() {
		this.player = new Player();
		this.aliens = new Alien[5][10];
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 10; c++) {
				this.aliens[r][c] = new Alien(-5 + (0.75* c), 9.5 - (0.75 * r));
			}
		}
		this.alienCount = 0;
		this.bullets = new Bullet[2];
		this.killCount = 50;
		this.walls = new Wall[3][24];
		for (int r = 0; r < 3; r++) {
			for (int c1 = 0; c1 < 6; c1++) {
				this.walls[r][c1] = new Wall(-4.8 + (0.2 * c1), 1 + (0.2 * r));
			}
			for (int c2 = 0; c2 < 6; c2++) {
				this.walls[r][c2 + 6] = new Wall(-2.0 + (0.2 * c2), 1 + (0.2 * r));
			}
			for (int c3 = 0; c3 < 6; c3++) {
				this.walls[r][c3 + 12]  = new Wall(0.8 + (0.2 * c3), 1 + (0.2 * r));
			}
			for (int c4 = 0; c4 < 6; c4++) {
				this.walls[r][c4 + 18] = new Wall(3.6 + (0.2 * c4), 1 + (0.2 * r));
			}
		}
	}
	
	public void moveAliens() {
		if (this.alienCount >= 325) {
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 10; c++) {
					this.aliens[r][c].setY(this.aliens[r][c].getY() - 0.5);
					this.aliens[r][c].setDirection(!this.aliens[r][c].getDirection());
				}
			}
			this.alienCount = 0;
		}
		else {
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 10; c++) {
					this.aliens[r][c].move();
				}
			}
			this.alienCount++;
		}
	}
	
	public void shootBullets() {
		if (this.bullets[0] == null) {
			if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_UP)) {
				this.bullets[0] = this.player.shoot();
			}
		}
		if (this.bullets[1] == null) {
			if (Math.random() < 0.1) {
				int ix = (int)(Math.random() * 5);
				int iy = (int)(Math.random() * 10);
				
				this.bullets[1] = this.aliens[ix][iy].shoot();
			}
		}
	}
	
	public void moveBullets() {
		if (this.bullets[0] != null) {
			if (this.bullets[0].getY() <= 10) this.bullets[0].move();
			else this.bullets[0] = null;
		}
		
		if (this.bullets[1] != null) {
			if (this.bullets[1].getY() >= -1) this.bullets[1].move();
			else this.bullets[1] = null;
		}
	}
	
	public void collide() {
		if (this.bullets[1] != null) {
			double playerDist = Math.sqrt(Math.pow(this.player.getX() - this.bullets[1].getX(), 2) + Math.pow(this.player.getY() - this.bullets[1].getY(), 2));
			if (playerDist <= 0.24 + this.bullets[1].getSize()) {
				this.player.hit();
				this.bullets[1].hit();
			}
		}
		
		double[][] alienDist = new double[5][10];
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 10; c++) {
				if (this.bullets[0] != null) {
					alienDist[r][c] = Math.sqrt(Math.pow(this.aliens[r][c].getX() - this.bullets[0].getX(), 2) + Math.pow(this.aliens[r][c].getY() - this.bullets[0].getY(), 2));
					if (alienDist[r][c] <= this.aliens[r][c].getSize() + this.bullets[0].getSize()) {
						this.aliens[r][c].hit();
						this.bullets[0].hit();
						this.killCount--;
					}
				}
			}
		}
		
		double[][] wallDist = new double[3][24];
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 24; c++) {
				for (int i = 0; i < 2; i++) {
					if (this.bullets[i] != null) {
						wallDist[r][c] = Math.sqrt(Math.pow(this.walls[r][c].getX() - this.bullets[i].getX(), 2) + Math.pow(this.walls[r][c].getY() - this.bullets[i].getY(), 2));
						if (wallDist[r][c] <= this.walls[r][c].getSize() + this.bullets[i].getSize()) {
							this.walls[r][c].hit();
							this.bullets[i].hit();
						}
					}
				}
			}
		}
	}
	
	public void play() {
		StdDraw.setXscale(-5.5, 5.5);
		StdDraw.setYscale(-1.0, 10.0);
			
		while(this.player.getSize() > 0.02 && this.killCount > 0) {
			StdDraw.clear(Color.BLACK);
			StdDraw.setPenColor(Color.WHITE);
			
			this.player.draw();
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 10; c++) {
					this.aliens[r][c].draw();
				}
			}			
			if (this.bullets[0] != null) this.bullets[0].draw();
			if (this.bullets[1] != null) this.bullets[1].draw();
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 24; c++) {
					this.walls[r][c].draw();
				}
			}
			
			this.player.move();
			moveAliens();
			shootBullets();
			moveBullets();
			collide();

			StdDraw.text(-4.5, -1, "Aliens Left: " + this.killCount);
			if (this.killCount == 0) StdDraw.text(4.5, -1, "You Win!");
			if (this.player.getSize() <= 0.02) StdDraw.text(4.5, -1, "You Lose");

			StdDraw.show(50);
		}
	}
}
