package exercises2;

import cse131.ArgsProcessor;

public class Max {

	public static void main(String[] args) {
		//
		// Below, prompt the user for two ints, x and y
		//
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int x1 = ap.nextInt("First integer");
		int x2 = ap.nextInt("Second integer");
		int max = 0;
		//
		// Now use what you have learned about conditional
		//   execution to print the larger of the two values.
		//
		if(x1 >= x2) max = x1;
		else max = x2;
		
		System.out.println("Maximum value of " + x1 + " and " + x2 + " is " + max);		
		//
		// Run this program testing on various inputs for
		//    x and y:  some where x < y, some where x > y,
		//              some where x == y

	}

}
