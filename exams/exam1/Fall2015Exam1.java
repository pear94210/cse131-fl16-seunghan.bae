package exam1;

import cse131.ArgsProcessor;

public class Fall2015Exam1 {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		//1(a)
		
		boolean x1 = 247 > 241;
		String x2 = 3.0 + "0";
		String x3 = "100" + (30 + 1);
		String x4 = (7 / 8) + "nly";
		int x5 = 5 / 2;
		double x6 = 5 / 2.0;
		boolean x7 = true && false;
		boolean x8 = !((1 > 2) || false);
		boolean x9 = 3 / 2 <= 1;
		boolean x10 = true || false;
		
		System.out.println(x1);
		System.out.println(x2);
		System.out.println(x3);
		System.out.println(x4);
		System.out.println(x5);
		System.out.println(x6);
		System.out.println(x7);
		System.out.println(x8);
		System.out.println(x9);
		System.out.println(x10);
		
		//2(a)
		System.out.println();
		
		int a = ap.nextInt("Value for a?");
		int b = ap.nextInt("Value for b?");
		int c = ap.nextInt("Value for c?");
		
		if (((a == b) && (b != c)) || ((b == c) && (c != a)) || ((c == a) && (a != b))) System.out.println(true);
		else System.out.println(false);
		
		//2(b)
		System.out.println();
		
		int N1 = ap.nextInt("How many random numbers?");
		int count = 0;
		
		for (int i = 0; i < N1; i++) {
			double r = Math.random();
			if (r < 0.5) count++;
		}
		
		System.out.println("You asked for " + N1 + " random numbers.");
		System.out.println("Of those, " + count + " were greater than 0.5.");
		
		//3(b)
		System.out.println();
		
		double d = Math.random();
		double r1 = d * 100.0;
		double r2 = d / 100.0;
		int k = (int) d;
		String s ="" + (Math.round(d * 100.0) / 100.0);
		
		System.out.println(d);
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(k);
		System.out.println(s);
		
		//4
		System.out.println();
		
		int[] poll = {3, 1, 3, 7, 6, 1, 3, 2};
		
		int N2 = poll.length;
		
		int M = 0;
		
		for (int i = 0; i < N2; ++i) {
			if (poll[i] > M) M = poll[i];
		}
		
		System.out.println("There are " + M  + " people running");
		
		for (int c1 = 0; c1 < M; ++c1) {
			int votes = 0;
			
			for (int j = 0; j < N2; ++j) {
				if (poll[j] == c1 + 1) votes++;
			}
			
			if (votes == 1) System.out.println("Candidate " + (c1 + 1) + " received " + votes + " vote");
			else System.out.println("Candidate " + (c1 + 1) + " received " + votes + " votes");
		}
		
	}

}
