package speeding;

import cse131.ArgsProcessor;

public class SpeedLimit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int speed = ap.nextInt("How fast are you driving?");
		int limit = ap.nextInt("What is the speed limit?");
		
		int fine = (speed - limit >= 10) ? (50 + 10 * (speed - limit - 10)) : 0;
		
		System.out.println("You reported a speed of " + speed + " MPH for a speed limit of " + limit + " MPH.");
		System.out.println("You went " + (speed - limit) + " MPH over the speed limit.");
		System.out.println("Your fine is $" + fine + ".");
	}

}
