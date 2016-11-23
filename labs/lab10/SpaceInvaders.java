package lab10;

import sedgewick.StdDraw;

public class SpaceInvaders {
	
	public static void main(String[] args) {
		while (true) {
			Game g = new Game();
			g.play();
			
			StdDraw.pause(5000);
		}
	}
	
}