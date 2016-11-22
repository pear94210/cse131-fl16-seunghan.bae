package arrays;
import cse131.ArgsProcessor;

public class PascalsTriangle {
	
	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int N = ap.nextInt("How many rows?");
		
		// an N by N array
		int[][] triangle = new int[N][N];
		
		for (int r = 0; r < triangle.length; r++) {
			for (int c = 0; c < triangle.length; c++) {
				// base case = 1
				if (c == 0) triangle[r][c] = 1;
				else if (c == r) triangle[r][c] = 1;
				else if (r < 0 || c < 0 || c > r) triangle[r][c]=0;
				// sum of the previous two entries
				else triangle[r][c] = triangle[r - 1][c] + triangle[r - 1][c - 1];
			}
		}
		
		System.out.println("     column");
		System.out.print("     ");
		for (int i = 0; i < triangle.length; i++) System.out.print(i + "   ");
		System.out.println();
		System.out.println("row");
		for (int i = 0; i < triangle.length; i++) {
			System.out.print(i + "    ");
			for (int j = 0; j < triangle.length; j++) {
				if (triangle[i][j] != 0) {
					if (triangle[i][j] < 10) System.out.print(triangle[i][j] + "   ");
					else if (triangle[i][j] < 100) System.out.print(triangle[i][j] + "  ");
					else System.out.print(triangle[i][j] + " ");
				}
			}
			System.out.println();
		}
		
	}

}
