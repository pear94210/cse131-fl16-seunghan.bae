package studio3;

import cse131.ArgsProcessor;

public class Eratosthenes {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int n = ap.nextInt("Size of the array?");
		int[] array = new int[n];
		
		for (int i = 0; i < array.length; i++) array[i] = i + 2;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				for (int j = i + 1; j < array.length; j++) {
					if (array[j] % array[i] == 0) array[j] = 0;
				}
			}
		}
		
		System.out.print("(Wrong) Primes under " + n + ": ");
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) System.out.print(array[i] + " ");
		}
		
		boolean[] newArray = new boolean[n];
		
		for (int i = 0; i < newArray.length; i++) {
			if (i < 2) newArray[i] = false;
			else newArray[i] = true;
		}
		
		for (int i = 0; i < newArray.length; i++) {
			if (newArray[i] != false) {
				for (int j = i + 1; j < newArray.length; j++) {
					if (j % i == 0) newArray[j] = false;
				}
			}
		}
		
		System.out.println();
		System.out.print("Primes under " + n + ": ");
		for (int i = 0; i < newArray.length; i++) {
			if (newArray[i] == true) System.out.print(i + " ");
		}
	}
}
