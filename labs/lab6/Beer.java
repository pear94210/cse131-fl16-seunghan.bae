package lab6;

public class Beer {

	public static void main(String[] args) {
		
		System.out.println(bottlesOfBeer(5));

	}
	
	public static String bottlesOfBeer(int n) {
		if (n == 0) return "";
		else {
			String beer = n + " bottles of beer on the wall, " + n +  " bottles of beer;" + "\n" + "you take one down, pass it around, " + (n - 1) +  " bottles of beer on the wall.";
			return beer + "\n\n" + bottlesOfBeer(n - 1);
		}
	}

}
