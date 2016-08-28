package exercises1;

import cse131.ArgsProcessor;

public class Change {

	public static void main(String[] args) {
		//
		// Below, prompt the user to enter a number of pennies
		//
		ArgsProcessor money = new ArgsProcessor(args);		
		int pennies = money.nextInt("How many pennies?");
		//
		// Then, compute and print out how many 
		//    dollars, quarters, dimes, nickels, and pennies
		// should be given in exchange for those pennies, so as to
		// minimize the number of coins (see the videos)
		//
		int dollars = pennies / 100;
		int leftPennies = pennies % 100;
		
		int quarters = leftPennies / 25;
		leftPennies = leftPennies % 25;
		
		int dimes = leftPennies / 10;
		leftPennies = leftPennies % 10;
				
		int nickels = leftPennies / 5;
		leftPennies = leftPennies % 5;
		
		System.out.println("For "+pennies+" pennies: "+dollars+" dollars "+quarters+" quarters "+dimes+" dimes "+nickels+" nickels "+leftPennies+ " pennies");
	}

}
