package mousefollower;

import sedgewick.StdDraw;

public class FollowTheMouse {

	public static void main(String[] args) {
		
		double[] tester = new double[]{.5, .5};
		//StdDraw.show(2000);
		while (true) {
			double [] position = changePosition(tester, getMousePosition(), 10);
			drawBall(position, 0.1);
		}

	}
	
	public static double[] getMousePosition() {
			
		double[] mouse = {StdDraw.mouseX(), StdDraw.mouseY()};
		
		return mouse;
		
	}
	
	public static void drawBall(double[] position, double radius) {
		
		StdDraw.circle(position[0], position[1], radius);
		
	}
	
	public static double[] changePosition(double[] position, double[] mousePosition, double speed) {
		
		double rate = Math.sqrt(Math.pow(mousePosition[0] - position[0], 2) + Math.pow(mousePosition[1] - position[1], 2)) / speed;
		
		double x = position[0] + (mousePosition[0] / rate);
		double y = position[1] + (mousePosition[1] / rate);
		double[] newPosition = {x, y};
		return newPosition;
		
	}

}
