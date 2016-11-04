package exercises4;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class MouseFollower {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int N = ap.nextInt("How much history?");
		
		double[] historyX = new double[N];
		double[] historyY = new double[N];

		int i = 0;
		
		while (true) {
			StdDraw.clear();
			//
			// Render one frame of your animation below here
			//
			historyX[i] = StdDraw.mouseX();
			historyY[i] = StdDraw.mouseY();
			
			i++;
			
			if (i >= N) i = 0;
			
			StdDraw.filledCircle(historyX[i], historyY[i], 0.01);
			
			//  
			// End of your frame
			//
			// Stdraw.show(..) achieves double buffering and
			//   avoids the tight spinning loop
			StdDraw.show(10);
		}

	}

}
