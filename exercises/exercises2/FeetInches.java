package exercises2;

import cse131.ArgsProcessor;

public class FeetInches {

	public static void main(String[] args) {
		//
		// Prompt the user for a number of inches
		//
		// Convert that into feet and inches
		//   BUT
		// Be sure to use the singular "foot" or "inch"
		//   where appropriate, as discussed in
		//   the introductory video
		//
		// For example, 61 inches would produce
		//    the output
		//   5 feet and 1 inch
		//
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int inch = ap.nextInt("How long is it in inches?");
		
		int feet = inch / 12;
		int inchLeft = inch % 12;
		
		if (inch == 1) System.out.print(inch + " inch will produce: ");
		else System.out.print(inch + " inches will produce: ");
		
		if (feet == 1) System.out.print(feet + " foot and ");
		else System.out.print(feet + " feet and ");
		
		if (inchLeft == 1) System.out.print(inchLeft + " inch");
		else System.out.print(inchLeft + " inches");
	}

}
