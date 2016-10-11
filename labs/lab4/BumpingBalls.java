package lab4;

import cse131.ArgsProcessor;
import sedgewick.*;

public class BumpingBalls {
	
	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int N = ap.nextInt("How many balls?");
		int iteration = ap.nextInt("How many iterations?");
		double[][] ball = new double[4][N];
		
		StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
		
		for (int i = 0; i < iteration; i++) {
			StdDraw.clear();
			
			for (int j = 0; j < N; j++) {
				ball[0][j] = (Math.random() * 1.9) - 0.95;
				ball[1][j] = (Math.random() * 1.9) - 0.95;
				ball[2][j] = (Math.random() * 0.02) + 0.05;
				ball[3][j] = (Math.random() * 0.02) + 0.05;
			}
			
			while (!StdDraw.mousePressed()) {
				for (int j = 0; j < N; j++) {
					if (Math.abs(ball[0][j] + ball[2][j]) > 0.95) ball[2][j] = -ball[2][j];
					if (Math.abs(ball[1][j] + ball[3][j]) > 0.95) ball[3][j] = -ball[3][j];
		            
		            for (int k = j + 1; k < N; k++) {
		            	if (Math.sqrt(Math.pow((ball[0][j] - ball[0][k]), 2)+Math.pow((ball[1][j] - ball[1][k]), 2)) <= 0.1) {
		            		ball[2][j] = -ball[2][j];
		            		ball[3][j] = -ball[3][j];
		            		ball[2][k] = -ball[2][k];
		            		ball[3][k] = -ball[3][k];
		            		StdAudio.play("sound/boing.au");
		            	}
		            }
				}
		            
		        for (int k = 0; k < N; k++) {
		           	ball[0][k] = ball[0][k] + ball[2][k]; 
					ball[1][k] = ball[1][k] + ball[3][k];
				}
				
				StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		        StdDraw.filledSquare(0, 0, 1.0);
					
				for (int k = 0; k < N; k++) {
					StdDraw.setPenColor(StdDraw.MAGENTA);
					//StdDraw.filledCircle(ball[0][k], ball[1][k], 0.05);
					StdDraw.picture(ball[0][k], ball[1][k], "images/chicken.jpg", 0.1, 0.1);
				}
		            
		        StdDraw.pause(25);
			}
			
			while (StdDraw.mousePressed()) StdDraw.pause(100);
		}
		
	}

}
