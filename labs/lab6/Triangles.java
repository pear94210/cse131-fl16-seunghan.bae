package lab6;

import java.awt.Color;

import sedgewick.*;

public class Triangles {

	public static void main(String[] args) {
		
		StdDraw.setXscale(-0.5, 0.5);
		StdDraw.setYscale(0, 1);
		
		double[] x0 = {-0.5, 0.5, 0};
		double[] y0 = {0, 0, Math.sqrt(3) / 2};
		StdDraw.filledPolygon(x0, y0);
		
		StdDraw.setPenColor(Color.WHITE);
		
		triangle(0, 0, 0.5);

	}
	
	public static void triangle(double x, double y, double length) {
		if (length <= 0.01) return;
		else {
			double[] x1 = {x, x + (length / 2), x - (length / 2)};
			double[] y1 = {y, y + (length * Math.sqrt(3) / 2), y + (length * Math.sqrt(3) / 2)};
			StdDraw.filledPolygon(x1, y1);
			StdDraw.pause(100);
			
			triangle(x + (length / 2), y, length / 2);
			triangle(x - (length / 2), y, length / 2);
			triangle(x, y + (length * Math.sqrt(3) / 2), length / 2);
		}
	}
	
}
