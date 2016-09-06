package lab2;

import cse131.ArgsProcessor;

public class Nim {

	public static void main(String[] args) {

		ArgsProcessor ap = new ArgsProcessor(args);
		
		int begSticks = ap.nextInt("How many sticks to begin with?");
		int sticks;
		boolean turn = ap.nextBoolean("Do you want to play first? (true / false)");
		int round = 0;
		
		if (turn == true) {
			int firstDraw = ap.nextInt("How many sticks to take? (1 / 2)");
			
			while (firstDraw > 2 || firstDraw < 1) {
				System.out.println("You can only take 1 or 2 sticks at a time");
				firstDraw = ap.nextInt("How many sticks to take? (1 / 2)");
			}
			
			sticks = begSticks - firstDraw;			
				
			System.out.println("Round " + round + ", " + begSticks + " sticks at start, human took " + firstDraw + ", so " + sticks + " sticks remain");
			
			begSticks = sticks;
			round = round + 1;
			
			if (begSticks == 0) System.out.println("Human wins");
		}
		
		while (begSticks > 0) {
			int computerDraw = (Math.random() < 0.5) ? 1 : 2;
			
			sticks = begSticks - computerDraw;
			
			System.out.println("Round " + round + ", " + begSticks + " sticks at start, computer took " + computerDraw + ", so " + sticks + " sticks remain");
			
			begSticks = sticks;
			round = round + 1;
			
			if (begSticks == 0) System.out.println("Computer wins");
			
			else {
				int humanDraw = ap.nextInt("How many sticks to take? (1 / 2)");
				
				while (humanDraw > 2 || humanDraw < 1) {
					System.out.println("You can only take 1 or 2 sticks at a time");
					humanDraw = ap.nextInt("How many sticks to take? (1 / 2)");
				}
				
				sticks = begSticks - humanDraw;			
				
				System.out.println("Round " + round + ", " + begSticks + " sticks at start, human took " + humanDraw + ", so " + sticks + " sticks remain");
				
				begSticks = sticks;
				round = round + 1;
				
				if (begSticks == 0) System.out.println("Human wins");
			}
		}
	}

}
