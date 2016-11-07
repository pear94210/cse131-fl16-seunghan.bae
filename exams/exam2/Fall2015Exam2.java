package exam2;

import sedgewick.StdDraw;

public class Fall2015Exam2 {

	public static boolean isOdd(int n) {
		if (n >= 2) {
			return isOdd(n - 2);
		}
		else if (n == 1) return true;
		else return false;
	}
	
	public static int f(int n) {
		if (n > 0) {
			return (3 * f(n - 1) + 4);
		}
		else return 1;
	}
	
	public static void squares(double x, double y, double hw) {
		if (hw <= 0) return;
		else {
			StdDraw.square(x, y, hw);
			squares(x, y, hw - 0.03);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(isOdd(14));
		System.out.println(isOdd(15));
		System.out.println(isOdd(1));
		System.out.println(isOdd(1002));
		
		System.out.println();
		System.out.println(f(2));
		
		squares(0.5, 0.5, 0.5);
	}

}