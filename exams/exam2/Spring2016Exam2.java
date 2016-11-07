package exam2;

public class Spring2016Exam2 {

	public static int numDigits(int x) {
		if (x < 10) return 1;
		else return 1 + numDigits(x / 10);
	}
	
	public static int f(int n) {
		if (n >= 2) return (f(n - 2) + 2 * f(n - 1));
		else return n;
	}
	
	public static void main(String[] args) {
		System.out.println(numDigits(1234567));
		
		System.out.println();
		System.out.println(f(4));
	}

}
