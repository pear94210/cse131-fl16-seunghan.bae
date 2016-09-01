package expectedvalue;

import cse131.ArgsProcessor;

public class Unexpected {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		double pSuccess = ap.nextDouble("Probability of the game start-up venture succeeding is...");
		
		int evGamer = (int)((pSuccess * 190000) + ((1-pSuccess) * 5000));
		int randomProgrammer = (int)((Math.random() * 50000) + 110000);
		
		boolean whichJob = (evGamer >= randomProgrammer);
		
		int utilityGamer = (int)(3 * Math.sqrt((double)evGamer));
		int utilityProgrammer = (int)(2 * Math.sqrt((double)randomProgrammer));
		
		boolean whichUtility = (utilityGamer >= utilityProgrammer);
		
		System.out.println("Gamer: $" + evGamer);
		System.out.println("Programmer: $" + randomProgrammer);
		System.out.println("You should be a gamer and not a programmer?" + "\t" + whichJob);
		System.out.println();		
		System.out.println("Gamer's EU: " + utilityGamer);
		System.out.println("Programmer's EU: " + utilityProgrammer);
		System.out.println("You should be a gamer and not a programmer?" + "\t" + whichUtility);
	}

}
