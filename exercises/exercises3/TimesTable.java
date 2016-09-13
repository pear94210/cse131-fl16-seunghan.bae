package exercises3;

import cse131.ArgsProcessor;

public class TimesTable {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("Max value for table?");
		
		//  Table should include rows and columns for 0...N  
		//     making N+1 rows and columns
		
		int[][] table = new int[N+1][N+1];
		
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				table[i][j] = i * j;
			}
		}
		
		System.out.print("   ");
		for (int j = 0; j <= N; j++) System.out.print("   " + j);
		System.out.print("\n");
		System.out.println("-----------------------------------------------------------------");
		
		for (int i = 0; i <= N; i++) {
			System.out.print(i + " | ");
			
			for (int j = 0; j <= N; j++) {
				if (table[i][j] < 10) System.out.print("  " + table[i][j] + " ");
				else System.out.print(" " + table[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

}
