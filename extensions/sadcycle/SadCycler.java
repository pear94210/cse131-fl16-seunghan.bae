package sadcycle;

import java.util.HashSet;
import java.util.Set;

import cse131.ArgsProcessor;

public class SadCycler {

	/**
	 * 
	 * @param base
	 * @param n
	 * @return the set of numbers in sad cycle
	 */
	public static Set<Long> findCycle(int base, long n) {
		Set<Long> set = new HashSet<Long>();
		set.add(n);
		
		for (int i = 0; i < 100; i++) {
			int[] digits = splitDigits(n);
			long sum = 0;
			
			for (int j = 0; j < digits.length; j++) sum = sum + (long)Math.pow(digits[j], 2);
			
			n = changeBase(base, sum);
			set.add(n);
		}
		
		return set;
	}
	
	/**
	 * 
	 * @param n
	 * @return split the digits of n and return as an array
	 */
	public static int[] splitDigits(long n) {
		int size = 1;
		long temp = n;
		
		while ((temp / 10) > 0) {
			size++;
			temp = temp / 10;
		}
		
		int[] digits = new int[size];
		
		for (int i = 0; i < digits.length; i++) {
			digits[i] = (int)((n / Math.pow(10, i)) % 10);
		}
		
		return digits;
	}
	
	/**
	 * 
	 * @param base
	 * @param n
	 * @return change the base of n
	 */
	public static long changeBase(int base, long n) {
		long ans = 0;
		int degree = 1;
		
		while (n >= Math.pow(base, degree)) degree++;
		degree = degree - 1;
		
		for (int i = 0; i < degree; i++) {
			int digit = (int)(n % Math.pow(base, i + 1) / Math.pow(base, i));
			n = n - (long)(digit * Math.pow(base, i));			
			ans = ans + (long)((Math.pow(10, i) * digit));
		}
		
		ans = ans + (long)((Math.pow(10, degree) * (n / Math.pow(base, degree))));
		
		return ans;
	}
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int n = ap.nextInt("Input Integer");
		
		for (int i = 1; i <= n; i++) {
			Set<Long> test = findCycle(10, i);
				if (test.contains(1l)) System.out.println(i + " is happy");
		}
	}
}
