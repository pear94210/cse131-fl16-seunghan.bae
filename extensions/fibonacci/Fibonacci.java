package fibonacci;

public class Fibonacci {
	
	/**
	 * Below copy your solution to recursive Fibonacci from studio
	 * @param n
	 * @return fib(n), computed recursively
	 */
	public static int recursive(int n) {
		if (n <= 1) return n;
		else return recursive(n - 1) + recursive(n - 2);
	}
	
	/**
	 * Below write your solution to Fibonacci, using iteration
	 * @param n
	 * @return fib(n), computed iteratively
	 */
	public static int iterative(int n) {
		if (n <= 1) return n;
		else {
			int fib1 = 0;
			int fib2 = 1;
			int fibn = 0;
			for (int i = 2; i <= n; i++) {
				fibn = fib1 + fib2;
				fib1 = fib2;
				fib2 = fibn;
			}
			return fibn;
		}
	}

}
