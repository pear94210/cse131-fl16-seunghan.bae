package studio1;

import cse131.ArgsProcessor;

public class Average {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int n1 = ap.nextInt("First integer");
		int n2 = ap.nextInt("Second integer");
		
		double avg = (n1 + n2) / 2d;
		
		System.out.println("Average of " + n1 + " and " + n2 + " is " + avg);
	}

}
