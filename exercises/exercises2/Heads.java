package exercises2;

import cse131.ArgsProcessor;

public class Heads {

	public static void main(String[] args) {

		ArgsProcessor ap = new ArgsProcessor(args);
		
		int count = ap.nextInt("How many times?");
		int numFlipsTotal = 0;
		
		for (int i = 0; i < count; i++) {
			
			// what are the concepts?
			int numHeads = 0;
			int numFlips = 0;

			// now flip a coin until we see 10 heads
			while (numHeads != 10) {		
				boolean isHeads = Math.random() < 0.5;
				
				if (isHeads) {
					numHeads = numHeads + 1;
				}
				
				numFlips = numFlips + 1;
			}
			// here, numHeads should be 10
		
			System.out.println("Number of flips was " + numFlips);
			
			numFlipsTotal = numFlipsTotal + numFlips;
		}
		
		double numFlipsAverage = Math.round(100 * numFlipsTotal / count) / 100.0;
		
		System.out.println("On average, " + numFlipsAverage + " flips to get 10 heads");
	}

}
