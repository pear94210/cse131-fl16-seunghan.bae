package RockPaperScissors;

import cse131.ArgsProcessor;

public class RPS {

	public static void main(String[] args) {

		ArgsProcessor ap = new ArgsProcessor(args);
		
		int round = ap.nextInt("How many rounds should we play?");
		
		int rotateNum = 0;
		
		int rotateWin = 0;
		int randWin = 0;
		
		for (int i = 0; i < round; i++) {
			int randNum = (int) (Math.random() * 3);
			
			if (randNum == 0) System.out.print("rock : ");
			else if (randNum == 1) System.out.print("paper : ");
			else System.out.print("scissors : ");
			
			if (i == 0) {
				System.out.println("rock");
			}
			else {
				if (rotateNum == 0) {
					rotateNum = 1;
					System.out.println("paper");
				}
				else if (rotateNum == 1) {
					rotateNum = 2;
					System.out.println("scissors");
				}
				else {
					rotateNum = 0;
					System.out.println("rock");
				}
			}
			
			if ((rotateNum - randNum == 1) || (randNum - rotateNum == 2)) {
				System.out.println("\t" + "Rotating player wins");
				rotateWin++;
			}
			else if ((randNum - rotateNum == 1) || (rotateNum - randNum == 2)) {
				System.out.println("\t" + "Random player wins");
				randWin++;
			}
			else System.out.println("\t" + "Draw");
		}
		
		double rotatePercent = Math.round(1000.0 * rotateWin / round) / 10d;
		double randPercent = Math.round(1000.0 * randWin / round) / 10d;
		
		System.out.println();
		System.out.println("Random player won " + randPercent + "%");
		System.out.println("Rotating player won " + rotatePercent + "%");
		
	}

}
