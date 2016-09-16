package arrays;
import cse131.ArgsProcessor;

public class Birthday {
	
	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int N = ap.nextInt("Number of people?");
		
		int[][] birthday = new int[12][31];
		
		for (int i = 0; i < N; i++) {
			int month = (int) (Math.random() * 12);
			int day = (int) (Math.random() * 31);
			
			for (int m = 0; m < 12; m++) {
				for (int d = 0; d < 31; d++) {
					if (m == month && d == day) birthday[m][d]++;
				}
			}
		}
		
		int[] monthSum = new int[12];
		int[] daySum = new int[31];
		
		for (int m = 0; m < 12; m++) {
			for (int d = 0; d < 31; d++) {
				monthSum[m] = monthSum[m] + birthday[m][d];
				daySum[d] = daySum[d] + birthday[m][d];
			}
		}
		
		double[] monthPercent = new double[12];
		double[] dayPercent = new double[31];
		
		for (int m = 0; m < 12; m++) monthPercent[m] = Math.round(10000.0 * monthSum[m] / N) / 100.0;
		for (int d = 0; d < 31; d++) dayPercent[d] = Math.round(10000.0 * daySum[d] / N) / 100.0;
		
		double monthAvg = 0;
		double dayAvg = 0;
		
		for (int m = 0; m < 12; m++) monthAvg = monthAvg + monthPercent[m];
		monthAvg = Math.round(100.0 * monthAvg / 12) / 100.0;
		for (int d = 0; d < 31; d++) dayAvg = dayAvg + dayPercent[d];
		dayAvg = Math.round(100.0 * dayAvg / 31) / 100.0;
		
		for (int m = 0; m < 12; m++) System.out.println("Month " + (m + 1) + ": " + monthPercent[m] + "%");
		System.out.println("On average, " + monthAvg + "%");
		System.out.println();
		for (int d = 0; d < 31; d++) System.out.println("Day " + (d + 1) + ": " + dayPercent[d] + "%");
		System.out.println("On average, " + dayAvg + "%");
		
		int sameBirthday = 0;
		
		for (int m = 0; m < 12; m++) {
			for (int d = 0; d < 31; d++) {
				if (birthday[m][d] > 1) sameBirthday = sameBirthday + birthday[m][d];
			}
		}
		
		double samePercent = Math.round(10000.0 * sameBirthday / N) / 100.0;
		
		System.out.println();
		System.out.println("Percentage of people who share birthday with other people: " + samePercent + "%");
		
	}

}
