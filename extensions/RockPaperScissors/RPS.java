package RockPaperScissors;

import cse131.ArgsProcessor;

public class RPS {

	public static void main(String[] args) {

		ArgsProcessor ap = new ArgsProcessor(args);
		
		int round = ap.nextInt("How many rounds should we play?");
		
		int rotateNum = 0;
		
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
		}
	}

}
