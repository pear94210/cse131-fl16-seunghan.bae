package studio5;

public class Methods {
	
	/**
	 * Implemented correctly
	 * @param x one thing to add
	 * @param y the other thing to add
	 * @return the sum
	 */
	public static int sum(int x, int y) {
		return x + y;
	}
	
	/**
	 * 
	 * @param x one factor
	 * @param y another factor
	 * @return the product of the factors
	 */
	public static int mpy(int x, int y) {
		if (x <= 0 || y <= 0) return 0;
		else {
			int mult = 0;
			for (int i = 0; i < y; i++) mult = mult + x;
			return mult;
		}
	}
	
	public static double avg3(int x, int y, int z) {
		return (x + y + z) / 3.0;
	}
	
	public static double sumArray(double[] array) {
		double arraySum = 0.0;
		for (int i = 0; i < array.length; i++) arraySum = arraySum + array[i];
		return arraySum;
	}
	
	public static double average(double[] array) {
		return sumArray(array) / array.length;
	}
	
	public static double productArray(double[] array) {
		double arrayProduct = 1.0;
		for (int i = 0; i < array.length; i++) arrayProduct = arrayProduct * array[i];
		return arrayProduct;
	}
	
	public static String pig(String s) {
		return s.substring(1) + s.substring(0, 1) + "ay";
	}
}
