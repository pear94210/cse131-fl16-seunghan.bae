package lab1;

import cse131.ArgsProcessor;

public class Nutrition {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		String name = ap.nextString("Name of the food?");
		double carbs = ap.nextDouble("Grams of carbohydrates in the food?");
		double fat = ap.nextDouble("Grams of fat in the food?");
		double protein = ap.nextDouble("Grams of protein in the food?");
		int statedCals = ap.nextInt("Calories stated on the food's label?");
		
		double carbsCals = Math.round(carbs * 40) / 10d;
		double fatCals = Math.round(fat * 90) / 10d;
		double proteinCals = Math.round(protein * 40) / 10d;
		double fiberCals = Math.round((carbsCals + fatCals + proteinCals - statedCals) * 10) / 10d;
		
		double carbsPercent = Math.round(carbsCals / statedCals * 1000) / 10d;
		double fatPercent = Math.round(fatCals / statedCals * 1000) / 10d;
		double proteinPercent = Math.round(proteinCals / statedCals * 1000) / 10d;
		
		boolean lowCarbs = carbsPercent <= 25;
		boolean lowFat = fatPercent <= 15;
		boolean coinFlip = Math.random() < 0.5;
		
		System.out.println(name + " has");
		System.out.println(carbs + " grams of carbohydrates = " + carbsCals + " Calories");
		System.out.println(fat + " grams of fat = " + fatCals + " Calories");
		System.out.println(protein + " grams of protein = " + proteinCals + " Calories");
		System.out.println();
		System.out.println("This food is said to have " + statedCals + " (available) Calories.");
		System.out.println("With " + fiberCals + " unavailable Calories, this food has " + (fiberCals / 4) + " grams of fiber");
		System.out.println();
		System.out.println("Approximately");
		System.out.println("\t" + carbsPercent + "% of your food is carbohydrates");
		System.out.println("\t" + fatPercent + "% of your food is fat");
		System.out.println("\t" + proteinPercent + "% of your food is protein");
		System.out.println();
		System.out.println("This food is acceptable for a low-carb diet?" +"\t" + lowCarbs);
		System.out.println("This food is acceptable for a low-fat diet?" + "\t" + lowFat);
		System.out.println("By coin flip, you should eat this food?" + "\t" + coinFlip);
	}
}
