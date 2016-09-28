package exercises4;

import cse131.ArgsProcessor;

public class Exam1 {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		//1(a)
		
		boolean ax = (5/2 >= 2.5);
		String bx = ("He" + (6-5) + "p");
		boolean cx = (!(false || (3 > 2)));
		double dx = 5.0 * 8;
		String ex = "2" + 3.0;
		boolean fx = (25 < 46);
		int gx = 3 / 2;
		String hx = (10 * 10) + "36";
		int ix = (int) (1.2 * 10);
		boolean jx = (true && false);
		
		System.out.println(ax);
		System.out.println(bx);
		System.out.println(cx);
		System.out.println(dx);
		System.out.println(ex);
		System.out.println(fx);
		System.out.println(gx);
		System.out.println(hx);
		System.out.println(ix);
		System.out.println(jx);
		
		//2(a)
		System.out.println();
		
		int a = ap.nextInt("Value for a?");
		int b = ap.nextInt("Value for b?");
		int c = ap.nextInt("Value for c?");
		
		if (((a > b) && (b > c)) || ((a < b) && (b < c))) System.out.println(true);
		else System.out.println(false);
		
		
		//2(b)
		System.out.println();
		
		int N1 = ap.nextInt("How many random numbers?");
		int count = 0;
		
		for (int i = 0; i < N1; i++) {
			double r = Math.random();
			if (r > 0.75) count++;
		}
		
		double ratio = Math.round(1000.0 * count / N1) / 10.0;
		
		System.out.println("You asked for " + N1 + " random numbers.");
		System.out.println("Of those, " + ratio + "% were greater than 0.75.");
		
		//4
		System.out.println();
		
		String[] names = {"HappyBBQ", "FancyFood", "EatRite", "GoodEats", "HungryHippo"};
		double[] prices = {1.25, 3.50, 8.00, 2.75, 10.15};
		
		int C = names.length;
		System.out.println("C is " + C);
		
		int N2 = ap.nextInt("How many people will be at the party?");
		double B = ap.nextInt("What is your budget?");
		
		System.out.println("For a party of " + N2 + ",");
		
		for (int i = 0; i < names.length; i++) {
			double cost = prices[i] * N2;
			
			double difference = B - cost;
			String direction = "";
			if (difference >= 0) direction = "below";
			else {
				direction = "above";
				difference = -difference;
			}
			
			System.out.println(names[i] + " will cost $" + cost + " which is $" + difference + " " + direction + " budget");
		}

	}

}
