package exercises3;

public class Shuffle {

	public static void main(String[] args) {
		String[] original = { "A", "B", "C", "D", "E", "F", "G", "H"};

		// print out original array
		for (int i = 0; i < original.length; i++) System.out.println("Original at " + i + " is " + original[i]);

		//
		// Follow the instructions on the web page to make a copy of
		// the original array, named shuffled, but with its elements
		// permuted from the original array.  The result is that the
		// shuffled array contains the same strings, but in a randomized
		// order.
		//
		
		String[] shuffled = new String[original.length];
		
		for (int j = shuffled.length - 1; j >= 0; j--) {
			int c = (int) (Math.random() * (j+1));
			
			shuffled[j] = original[c];
			
			for (int j2 = c; j2 < shuffled.length - 1; j2++) original[j2] = original[j2 + 1];
		}
		
		System.out.println();
		for (int k = 0; k < shuffled.length; k++) System.out.println("Shuffled at " + k + " is " + shuffled[k]);
		
	}
	
}