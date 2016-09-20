package lab3;

import cse131.ArgsProcessor;

public class Dice {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int number = ap.nextInt("How many dice do we have?");
		int time = ap.nextInt("How many times do we throw the dice?");
		int[] dice = new int[number];
		int sameDice = 0;
		int[] sumStat = new int[number * 6];
		
		for (int i = 0; i < time; i++) {
			int diceSum = 0;
			int sameCount = 0;
			
			for (int j = 0; j < dice.length; j++) {
				dice[j] = (int) (Math.random() * 6 + 1);
				diceSum = diceSum + dice[j];
				
				System.out.print(dice[j] + " ");
			}
			
			for (int k = 0; k < dice.length - 1; k++) {
				if (dice[k] == dice[dice.length - 1]) sameCount++;
			}
			
			if (sameCount == dice.length - 1) sameDice++;
			
			System.out.print("(sum = " + diceSum + ")");
			System.out.println();
			
			for (int l = 0; l < sumStat.length; l++) {
				if (diceSum == l + 1) sumStat[l]++;
			}
		}
		
		double sameRatio = Math.round(10000.0 * sameDice / time) / 100.0;
		
		System.out.println();
		System.out.println(sameRatio + "% of the throws resulted in the same value for all dice");
		
		System.out.println();
		System.out.println("# of throws with the sum...");
		for (int m = 0; m < sumStat.length; m++) {
			if (sumStat[m] != 0) System.out.println((m + 1) + ": " + sumStat[m] + " (" + (Math.round(10000.0 * sumStat[m] / time) / 100.0) + "%)");
		}
	}

}
