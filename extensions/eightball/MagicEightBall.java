package eightball;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class MagicEightBall {

	public static void main(String[] args) {
		
		StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		while (true) {
			StdDraw.clear();
			
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledCircle(0, 0, 1);
			
			String question = ap.nextString("Ask a boolean-type question");
			
			String answer;
			
			double randNum = Math.random() * 20.0;
			if (randNum < 1) answer = "It is certain";
			else if (randNum < 2) answer = "It is decidedly so";
			else if (randNum < 3) answer = "Without a doubt";
			else if (randNum < 4) answer = "Yes, definitely";
			else if (randNum < 5) answer = "You may rely on it";
			else if (randNum < 6) answer = "As I see it, yes";
			else if (randNum < 7) answer = "Most likely";
			else if (randNum < 8) answer = "Outlook good";
			else if (randNum < 9) answer = "Yes";
			else if (randNum < 10) answer = "Signs point to yes";
			else if (randNum < 11) answer = "Reply hazy try again";
			else if (randNum < 12) answer = "Ask again later";
			else if (randNum < 13) answer = "Better not tell you now";
			else if (randNum < 14) answer = "Cannot predict now";
			else if (randNum < 15) answer = "Concentrate and ask again";
			else if (randNum < 16) answer = "Don't count on it";
			else if (randNum < 17) answer = "My reply is no";
			else if (randNum < 18) answer = "My sources say no";
			else if (randNum < 19) answer = "Outlook not so good";
			else answer = "Very doubtful";
			
			for (int i = 0; i < 256; i++) {
				Color triangle = new Color(i, i, i);
				StdDraw.setPenColor(triangle);
				
				double[] x = {-0.5, 0.5, 0};
				double[] y = {0.5 * Math.pow(3, 0.5) / 3, 0.5 * Math.pow(3, 0.5) / 3, -0.5 * Math.pow(3, 0.5) / 3 * 2};
				
				StdDraw.filledPolygon(x, y);
				
				Color text = new Color(0, 0, i);
				StdDraw.setPenColor(text);
				StdDraw.text(0, 0.2, answer);
				
				Color click = new Color(i, 0, 0);
				StdDraw.setPenColor(click);
				StdDraw.text(0,  0,  "CLICK here");
				StdDraw.text(0,  -0.1, "to ask");
				StdDraw.text(0,  -0.2, "again");
			}
			
			while (!StdDraw.mousePressed()) StdDraw.pause(100);
			
			while (StdDraw.mousePressed()) StdDraw.pause(100);
		}

	}

}
