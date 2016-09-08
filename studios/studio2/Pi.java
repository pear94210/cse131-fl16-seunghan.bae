package studio2;

public class Pi {

	public static void computePi() {
				
		double ans = 0.0;
		int totalCount = 0;
		int circleCount = 0;
		double ratio = 0.0;
		
		for (int i = 0; i < 1000000; i++) {
			totalCount++;
			
			double x = Math.random();
			double y = Math.random();
						
			double length = Math.sqrt((x - 0.5) * (x - 0.5) + (y - 0.5) * (y - 0.5));
			
			if (length < 0.5) circleCount++;
		}
		
		ratio = 1.0 * circleCount / totalCount;
		ans = ratio / 0.25;
		
		System.out.println("Our group shows Pi = " + ans);

	}
	
	public static void main(String[] args) {		
		computePi();
	}

}
