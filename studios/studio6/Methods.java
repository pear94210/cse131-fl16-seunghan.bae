package studio6;

public class Methods {

	// Your methods go below this line
	public static int fact(int n) {
		if (n <= 0) return 1;
		else return (n * fact(n - 1));
	}
	
	public static int fib(int n) {
		if (n <= 1) return n;
		else return fib(n - 1) + fib(n - 2);
	}
	
	public static boolean isOdd(int n) {
		if (n <= 0) return false;
		else return !isOdd(n - 1);
	}
	
	public static int sum(int a, int b) {
		if (b <= 0) return a;
		else return sum(a + 1, b - 1);
	}
	
	public static int sumDownBy2(int n) {
		if (n <= 1) return n;
		else return n + sumDownBy2(n - 2);
	}
	
	public static double harmonicSum(int n) {
		if (n <= 1) return 1;
		else return harmonicSum(n - 1) + (1.0 / n);
	}
	
	public static int mult(int a, int b) {
		if (b <= 0) return 0;
		else return a + mult(a, b - 1);
	}
	
}
