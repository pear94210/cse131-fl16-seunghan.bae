package studio3;

import cse131.ArgsProcessor;

public class Eratosthenes {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int n = ap.nextInt("Size of the array?");
		int[] array = new int[n];
		
		for (int i = 0; i < array.length; i++) array[i] = i + 2;
		
	}

}
