package lab6;

import java.awt.Color;

import sedgewick.*;

public class Triangles {

	public static void main(String[] args) {
		
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, 1);
		
		double[] x0 = {0, 1, 0.5};
		double[] y0 = {0, 0, Math.sqrt(3) / 2};
		StdDraw.filledPolygon(x0, y0);
		
		StdDraw.setPenColor(Color.WHITE);
		
		triangle(6, 0.25, 0.5, 0.75, Math.sqrt(3) / 4, 0, Math.sqrt(3) / 4);

	}
	
	public static void triangle(int n, double x1, double x2, double x3, double y1, double y2, double y3) {
		if (n == 0) return;
		else {
			double[] x = {x1, x2, x3};
			double[] y = {y1, y2, y3};
			StdDraw.filledPolygon(x, y);
			//StdDraw.pause(500);
			triangle(n - 1, x1 / 2, x2 / 2, x3 / 2, y1 /2, 0, y3 / 2);
			triangle(n - 1, x1 * 1.5, x2, x3 * 5 / 6, y1 * 1.5, y1, y3 * 1.5);
			//triangle(n - 1, )
		}
	}
	
}
