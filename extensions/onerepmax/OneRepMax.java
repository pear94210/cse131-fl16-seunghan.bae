package onerepmax;

import cse131.ArgsProcessor;

public class OneRepMax {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int successWeight = ap.nextInt("Successful weight");
		int successReps = ap.nextInt("Successful reps");
		int desiredReps = ap.nextInt("Desired reps");
		
		int maxWeight = (int) (successWeight * (1 + (successReps / 30.0))) / 5 * 5;
		int fiveRepsWeight = (int) (maxWeight / (1 + (desiredReps / 30.0))) / 5 * 5;
		
		System.out.println("One-rep max: " + maxWeight);
		System.out.println("Weight for 5 reps: " + fiveRepsWeight);
		
		for (int i = 1; i <= 10; i++) {
			int percent = 100 - (5 * i);
			int percentWeight = (int) (maxWeight * percent / 100d) / 5 * 5;
			
			System.out.println(percent + "% 1 RM: " + percentWeight);
		}
		
	}

}
