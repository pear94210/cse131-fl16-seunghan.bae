package lab10;

import sedgewick.StdDraw;

public class SpaceInvaders {
	
	Alien[][] aliens;
	Player player;
	Wall[] walls;
	
	public SpaceInvaders() {
		this.aliens = new Alien[5][10];
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 10; c++) {
				aliens[r][c] = new Alien(-5 + (0.75* c), 9.5 - (0.75 * r));
			}
		}
		
		this.player = new Player();
		
		this.walls = new Wall[5];
		for (int i = 0; i < 5; i++) {
			walls[i] = new Wall(-4.4 + (2.2 * i));
		}
	}
		
//		for (int j = 0; j < 11; j++) {
//			for (int i = 0; i < 13; i++) {
//				rightMoveAlien(aliens);
//				StdDraw.pause(200);
//			}
//			downMoveAlien(aliens);
//			StdDraw.pause(200);
//			for (int i = 0; i < 13; i++) {
//				aliens[r][c].moveLeft();
//				StdDraw.pause(200);
//			}
//			downMoveAlien(aliens);
//			StdDraw.pause(200);
//		}
	
	
	public void playGame() {
		StdDraw.setXscale(-5.5, 5.5);
		StdDraw.setYscale(-1.0, 10.0);
		
		this.player.draw();
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 10; c++) {
				this.aliens[r][c].draw();
			}
		}
		for (int i = 0; i < 5; i++) {
			this.walls[i].draw();
		}
		
		while(true) {
			this.player.move();
			Bullet b = this.player.shoot();
			if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_UP)) {
				b.draw();
				while (b.getY() <= 11) {
					b.move("player");
				}
			}
			this.player.shoot();
			
		}		
	}
}