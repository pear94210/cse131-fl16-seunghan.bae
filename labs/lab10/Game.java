package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Game {

	private Player player;
	private Alien[][] aliens;
	private Bullet[] bullets;
	private Wall[][] walls;
	private Spaceship[] ss;
	private int alienCount, killCount, ssCount, point;

	public Game() {
		this.player = new Player();
		this.aliens = new Alien[5][10];
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 10; c++) {
				this.aliens[r][c] = new Alien(-5 + (0.75* c), 9.0 - (0.75 * r));
			}
		}
		this.bullets = new Bullet[2];
		this.walls = new Wall[3][24];
		for (int r = 0; r < 3; r++) {
			for (int c1 = 0; c1 < 6; c1++) {
				this.walls[r][c1] = new Wall(-4.5 + (0.2 * c1), 1 + (0.2 * r));
			}
			for (int c2 = 0; c2 < 6; c2++) {
				this.walls[r][c2 + 6] = new Wall(-1.8 + (0.2 * c2), 1 + (0.2 * r));
			}
			for (int c3 = 0; c3 < 6; c3++) {
				this.walls[r][c3 + 12]  = new Wall(0.8 + (0.2 * c3), 1 + (0.2 * r));
			}
			for (int c4 = 0; c4 < 6; c4++) {
				this.walls[r][c4 + 18] = new Wall(3.5 + (0.2 * c4), 1 + (0.2 * r));
			}
		}
		this.ss = new Spaceship[1];
		this.alienCount = 0;
		this.killCount = 0;
		this.ssCount = 0;
		this.point = 0;
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
	
	public void launchSS() {
		if (this.ss[0] == null) {
			if (Math.random() < 0.5) this.ss[0] = new Spaceship(true);
			else this.ss[0] = new Spaceship(false);
		}
	}
	
	public void moveSS() {
		if (this.ss[0] != null) {
			if (this.ss[0].getX() > 7 || this.ss[0].getX() < -7) this.ss[0] = null;
			else this.ss[0].move();
		}
	}

	public void shootBullets() {
		if (this.bullets[0] == null) {
			if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_UP)) {
				this.bullets[0] = this.player.shoot();
			}
		}
		if (this.bullets[1] == null) {
			if (Math.random() < 0.2) {
				int ix = (int)(Math.random() * 5);
				int iy = (int)(Math.random() * 10);
				this.bullets[1] = this.aliens[ix][iy].shoot();
			}
		}
	}

	public void moveBullets() {
		if (this.bullets[0] != null) {
			if (this.bullets[0].getY() <= 10 && this.bullets[0].getX() < 100) this.bullets[0].move();
			else this.bullets[0] = null;
		}

		if (this.bullets[1] != null) {
			if (this.bullets[1].getY() >= -1 && this.bullets[1].getX() < 100) this.bullets[1].move();
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

		if (this.bullets[0] != null) {
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 10; c++) {
					double alienDist = Math.sqrt(Math.pow(this.aliens[r][c].getX() - this.bullets[0].getX(), 2) + Math.pow(this.aliens[r][c].getY() - this.bullets[0].getY(), 2));
					if (alienDist <= this.aliens[r][c].getSize() + this.bullets[0].getSize()) {
						this.aliens[r][c].hit();
						this.bullets[0].hit();
						this.killCount++;
					}
				}
			}
		}

		for (int i = 0; i < 2; i++) {
			if (this.bullets[i] != null) {
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 24; c++) {
						double wallDist = Math.sqrt(Math.pow(this.walls[r][c].getX() - this.bullets[i].getX(), 2) + Math.pow(this.walls[r][c].getY() - this.bullets[i].getY(), 2));
						if (wallDist <= this.walls[r][c].getSize() + this.bullets[i].getSize()) {
							this.walls[r][c].hit();
							this.bullets[i].hit();
						}
					}
				}
			}
		}
		
		if (this.ss[0] != null && this.bullets[0] != null) {
			double ssDist = Math.sqrt(Math.pow(this.ss[0].getX() - this.bullets[0].getX(), 2) + Math.pow(this.ss[0].getY() - this.bullets[0].getY(), 2));
			if (ssDist <= this.ss[0].getSize() + this.bullets[0].getSize()) {
				this.ss[0].hit();
				this.bullets[0].hit();
				this.ssCount++;
			}
		}
	}
	
	public void paCollide() {
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 10; c++) {
				double paDist = Math.sqrt(Math.pow(this.player.getX() - this.aliens[r][c].getX(), 2) + Math.pow(this.player.getY() - this.aliens[r][c].getY(), 2));
				if (paDist <= 0.24 + this.aliens[r][c].getSize()) this.player.setLife(0);
			}
		}
	}
	
	public void resetAliens() {
		if (killCount > 0 && killCount % 50 == 0) {
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 10; c++) {
					this.aliens[r][c] = new Alien(-5 + (0.75* c), 9.5 - (0.75 * r));
				}
			}
			this.alienCount = 0;
		}
	}

	public void play() {
		StdDraw.setXscale(-5.5, 5.5);
		StdDraw.setYscale(-1.0, 10.0);

		while(this.player.getLife() != 0) {
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
			paCollide();
			resetAliens();
			if (Math.random() < 0.1) launchSS();
			if (this.ss[0] != null) {
				this.ss[0].draw();
				moveSS();
			}
			
			this.point = this.killCount + (this.ssCount * 50);

			StdDraw.textLeft(-5.5, -1, this.killCount + " ALIENS KILLED, " + this.ssCount + " SPACESHIP HIT");
			StdDraw.textRight(5.5, -1, "LIFE: " + this.player.getLife());

			if (this.player.getLife() == 0) {
				StdDraw.clear(Color.BLACK);
				StdDraw.text(0, 6, "GAME OVER");
				StdDraw.text(0, 5, "Your Point: " + this.point);
				StdDraw.text(0, 4, "New game will begin in 5 seconds.");
			}

			StdDraw.show(50);
		}
	}
}
