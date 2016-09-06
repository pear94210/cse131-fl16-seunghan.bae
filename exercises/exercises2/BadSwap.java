package exercises2;

import cse131.ArgsProcessor;

public class BadSwap {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int x = ap.nextInt("Enter x");
		int y = ap.nextInt("Enter y");
		
		if (x > y) {
			x = y;     // Bad
			y = x;     // swap!!
		}
		
		System.out.println("x and y are now"
				+ x + " and " + y);
		
		//
		// Student fill in with comments below this line:
		//   Why does the code above *not* swap the values of
		//      x and y?
		//   Note that the bad swap executes only if x>y
		//
		// Your answer:
		//
		// When we say "x = y;"
		// the value that x contains is switched to the value of y.
		// Then when we say "y = x;"
		// the original value of x is already gone
		// and the value y gets is the value that x has instead,
		// which is the value of y.

	}

}
