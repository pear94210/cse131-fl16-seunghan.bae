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
		
		//double expectedRuin;
		
		//if (winChance == lossChance) expectedRuin = 1 - (1.0 * startAmount / winAmount);
		//else expectedRuin = ((lossChance / winChance))
		
		//System.out.println("Expected Ruin Rate: " + expectedRuin);
	}

}
