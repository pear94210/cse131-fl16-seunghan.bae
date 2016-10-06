package calculator;

public class Computations {

	/**
	 * Create the static methods as described on the 
	 * description for this assignment.
	 */
	
	public static double addDoubles(double d1, double d2) {
		return d1 + d2;
	}
	
	public static double subtractDoubles(double d1, double d2) {
		return d1 - d2;
	}
	
	public static double divideDoubles(double d1, double d2) {
		if (d2 == 0) return 0.0;
		else return d1 / d2;
	}
	
	public static double multiplyDoubles(double d1, double d2) {
		return d1 * d2;
	}
	
	public static int addInts(int i1, int i2) {
		return i1 + i2;
	}
	
	public static int subtractInts(int i1, int i2) {
		return i1 - i2;
	}
	
	public static int divideInts(int i1, int i2) {
		if (i2 == 0) return 0;
		else return i1 / i2;
	}
	
	public static int multiplyInts(int i1, int i2) {
		return i1 * i2;
	}
	
	public static String concatenate(String s1, String s2) {
		return s1 + s2;
	}
	
	public static boolean andBoolean(boolean b1, boolean b2) {
		return b1 && b2;
	}
	
	public static boolean orBoolean(boolean b1, boolean b2) {
		return b1 || b2;
	}
	
	public static double intToDouble(int in) {
		return 1.0 * in;
	}
	
	public static double doubleToDouble(double in) {
		return in;
	}
	
	public static double stringToDouble(String in) {
		throw new UnsupportedOperationException();
	}
	
	public static double booleanToDouble(boolean in) {
		throw new UnsupportedOperationException();
	}
	
	public static int intToInt(int in) {
		return in;
	}
	
	public static int doubleToInt(double in) {
		return (int)in;
	}
	
	public static int stringToInt(String in) {
		throw new UnsupportedOperationException();
	}
	
	public static int booleanToInt(boolean in) {
		throw new UnsupportedOperationException();
	}
	
	public static String intToString(int in) {
		return "" + in;
	}
	
	public static String doubleToString(double in) {
		return "" + in;
	}
	
	public static String stringToString(String in) {
		return in;
	}
	
	public static String booleanToString(boolean in) {
		if (in == true) return "true";
		else return "false";
	}
	
	public static boolean intToBoolean(int in) {
		throw new UnsupportedOperationException();
	}
	
	public static boolean doubleToBoolean(double in) {
		throw new UnsupportedOperationException();
	}
	
	public static boolean stringToBoolean(String in) {
		throw new UnsupportedOperationException();
	}
	
	public static boolean booleanToBoolean(boolean in) {
		return in;
	}
	
}
