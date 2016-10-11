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
		
		System.out.println(name + " has");
		nutrition(carbs, fat, protein, statedCals);
	}
	
	public static void nutrition(double c, double f, double p, int s) {
		double carbsCals = calories(c, 4);
		double fatCals = calories(f, 9);
		double proteinCals = calories(p, 4);
		double fiberCals = roundOne(carbsCals + fatCals + proteinCals - s);
		
		double carbsPercent = percentage(carbsCals, s);
		double fatPercent = percentage(fatCals, s);
		double proteinPercent = percentage(proteinCals, s);
		
		boolean lowCarbs = carbsPercent <= 25;
		boolean lowFat = fatPercent <= 15;
		boolean coinFlip = Math.random() < 0.5;
		
		System.out.println(c + " grams of carbohydrates = " + carbsCals + " Calories");
		System.out.println(f + " grams of fat = " + fatCals + " Calories");
		System.out.println(p + " grams of protein = " + proteinCals + " Calories");
		System.out.println();
		System.out.println("This food is said to have " + s + " (available) Calories.");
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
	
	public static double calories(double nutrient, int perNut) {
		double calories = nutrient * perNut;
		return roundOne(calories);
	}
	
	public static double percentage(double d1, double d2) {
		double percent = d1 / d2 * 100;
		return roundOne(percent);
	}
	
	public static double roundOne(double d) {
		return Math.round(d * 10) / 10d;
	}
}
