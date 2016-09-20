package exercises4;

import cse131.ArgsProcessor;

public class Pitches {

	public static void main(String[] args) {
		// encoding has 0 as concert A
		//    1 would be Bb, just above A
		//   -1 would be Ab, just below A
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int pitch1 = ap.nextInt("1st Pitch:");
		int pitch2 = ap.nextInt("2nd Pitch:");
		
		double frequency1 = 440 * Math.pow(2, pitch1/12.0);
		double frequency2 = 440 * Math.pow(2, pitch2/12.0);
		
		System.out.println("Frequency of 1st Pitch = " + frequency1);
		System.out.println("Frequency of 1st Pitch = " + frequency2);
		
		System.out.println("Ratio = " + (frequency2 / frequency1));
	}

}
