package exercises4;

import java.awt.Color;

import sedgewick.StdDraw;

public class GraphicsDemo {

	public static void main(String[] args) {
		// blue point (look carefully, will be very small on your screen)
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.point(0.5, 0.5);
		// larger green point
		StdDraw.setPenColor(Color.GREEN);
		StdDraw.setPenRadius(0.05);
		StdDraw.point(0.2, 0.2);
		// unfilled red triangle
		StdDraw.setPenColor(Color.RED);
		StdDraw.setPenRadius(0.01);
		StdDraw.line(0, 0, 1, 0);
		StdDraw.line(0, 0, 0.5, Math.sqrt(3)/2);
		StdDraw.line(0.5, Math.sqrt(3)/2, 1, 0);
		// yellow circle, filled
		StdDraw.setPenColor(Color.YELLOW);
		StdDraw.filledCircle(0.7, 0.7, 0.2);
		// filled blue rectangle
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.filledRectangle(0.9, 0.1, 0.1, 0.4);

	}

}
