package minesweeper;

import cse131.ArgsProcessor;

public class MineSweeper {

	public static void main (String[] args) {
		
		//
		// Do not change anything between here ...
		//
		ArgsProcessor ap = new ArgsProcessor(args);
		int cols = ap.nextInt("How many columns?");
		int rows = ap.nextInt("How many rows?");
		double percent = ap.nextDouble("What is the probability of a bomb?");
		//
		// ... and here
		//
		//  Your code goes below these comments
		//
		boolean[][] minesweeper = new boolean[rows + 2][cols + 2];
		
		for (int r = 1; r <= rows; r++) {
			for (int c = 1; c <= cols; c++) minesweeper[r][c] = (Math.random() < percent);
		}
		
		for (int r = 1; r <= rows; r++) {
			for (int c = 1; c <= cols; c++) {
				if (minesweeper[r][c] == true) System.out.print("* ");
				else System.out.print(". ");
			}
			
			System.out.println();
		}
		
		System.out.println();
		
		int[][] mineCount = new int[rows + 2][cols + 2];
		
		for (int r = 1; r <= rows; r++) {
			for (int c = 1; c <= cols; c++) {
				for (int i = r - 1; i <= r + 1; i++){
					for (int j = c - 1; j <= c + 1; j++) if(minesweeper[i][j] == true) mineCount[r][c]++;
				}
			}
		}
		
		for (int r = 1; r <= rows; r++) {
			for (int c = 1; c <= cols; c++) {
				if (minesweeper[r][c] == true) System.out.print("* ");
				else System.out.print(mineCount[r][c] + " ");
			}
			
			System.out.println();
		}
		
	}
	
}
