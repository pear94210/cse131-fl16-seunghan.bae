package studio2;

import cse131.ArgsProcessor;

public class Ruin {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int startAmount = ap.nextInt("Amount of money that you start with:");
		double winChance = ap.nextDouble("Probability that you win:");
		double lossChance = 1 - winChance;
		int winAmount = ap.nextInt("Amount of money to make you win:");
		int totalPlays = ap.nextInt("Number of simulations:");
		int winCount = 0;
		
		for (int i = 0; i < totalPlays; i++) {
			
			int round = 0;
			String winLose = "";
			int roundAmount = startAmount;
			
			while (roundAmount > 0 && roundAmount < winAmount) {
				round++;
				
				double random = Math.random();
				
				if (random < winChance) roundAmount++;
				else roundAmount--;
			}
			
			if (roundAmount == 0) winLose = "LOSE";
			else if (roundAmount == winAmount) {
				winLose = "WIN";
				winCount++;
			}
			
			System.out.println("Simulation " + (i + 1) + ": " + round + " rounds" + "     " + winLose);
		}
		
		double actualRuin = 1.0 * (totalPlays - winCount) / totalPlays;
		double expectedRuin;
		
		if (winChance == lossChance) expectedRuin = 1 - (1.0 * startAmount / winAmount);
		else expectedRuin = (Math.pow(lossChance / winChance, startAmount) - Math.pow(lossChance / winChance, winAmount)) / (1 - Math.pow(lossChance / winChance, winAmount));
		
		System.out.println();
		System.out.println("Losses : " + (totalPlays - winCount) + "\t" + "Simulations: " + totalPlays);
		System.out.println("Actual Ruin Rate: " + actualRuin);
		System.out.println("Expected Ruin Rate: " + expectedRuin);
	}

}
