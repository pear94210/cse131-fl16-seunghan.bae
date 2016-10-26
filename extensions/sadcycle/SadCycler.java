package sadcycle;

import java.util.Set;

public class SadCycler {

	/*public Set<Long> findCycle(int base, long n) {
		
	}*/
	
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
	
	/*public long changeBase(int base, long n) {
		long ans = 0;
		int k = base;
		
		while (n / k >=0) {
			
		}
	}*/
	
	public static void main(String[] args) {
		
	}
}
