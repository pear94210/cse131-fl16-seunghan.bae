package homeowning;

import cse131.ArgsProcessor;

public class HomeOwning {

	public static void main(String[] args) {
	
		ArgsProcessor ap = new ArgsProcessor(args);
		
		String name = ap.nextString("Name of the apartment complex");
		String zipCode = ap.nextString("Zip code of the apartment");
		int monthlyRent = ap.nextInt("Monthly rent of the apartment");
		int dailyInterest = (int)(100 * ap.nextDouble("Daily interest payment for your mortgage on the house"));
		
		int yearlyRent = monthlyRent * 12;
		double weeklyRent = Math.round(yearlyRent / 52d * 100) / 100d;
		
		double yearlyInterest = (dailyInterest * 365) / 100d;
		double weeklyInterest = (dailyInterest * 7) / 100d;
		
		boolean housing = (weeklyRent >= weeklyInterest);
		String decision = (housing == true) ? "own" : "rent";
		
		System.out.println(name + " is located in the Zip Code " + zipCode);
		System.out.println("Rent per year: " + yearlyRent);
		System.out.println("Rent per week: " + weeklyRent);
		System.out.println();
		System.out.println("Interest per year: " + yearlyInterest);
		System.out.println("Interest per week: " + weeklyInterest);
		System.out.println();
		System.out.println("I should " + decision);
	}

}
