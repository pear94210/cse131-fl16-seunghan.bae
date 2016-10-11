package lab5;

public class Lab5Methods {
	
	/**
	 * @param n >= 0
	 * @return int = n + (n - 2) + (n - 4) + ... + 0
	 */
	public static int sumDownBy2(int n) {
		if (n < 0) return 0;
		else {
			int sum = n;
			int addValue = n - 2;
			
			while (addValue >=0) {
				sum = sum + addValue;
				addValue = addValue - 2;
			}
			
			return sum;
		}
	}
	
	/**
	 * @param n > 0
	 * @return double = 1/1 + 1/2 + 1/3 + ... + 1/n
	 */
	public static double harmonicSum(int n) {
		if (n <= 0) return 0.0;
		else {
			double sum = 0;
			for (int i = 1; i <= n; i++) sum = sum + (1.0 / i);
			return sum;
		}
	}
	
	/**
	 * @param k >= 0
	 * @return double = 1/1 + 1/2 + 1/4 + ... + 1/2^k
	 */
	public static double geometricSum(int k) {
		if (k < 0) return 0.0;
		else {
			double sum = 0;
			for (int i = 0; i <= k; i++) sum = sum + (1.0 / Math.pow(2, i));
			return sum;
		}
	}
	
	/**
	 * @param j > 0
	 * @param k > 0
	 * @return int = j*k
	 */
	public static int multPos(int j, int k) {
		if (j <= 0 || k <= 0) return 0;
		else {
			int sum = 0;
			for (int i = 0; i < k; i++) sum = sum + j;
			return sum;
		}
	}
	
	/**
	 * @param j
	 * @param k
	 * @return int = j*k
	 */
	public static int mult(int j, int k) {
		if (j <= 0 && k <= 0) return multPos(-j, -k);
		else if (j > 0 && k <= 0) return -multPos(j, -k);
		else if (j <= 0 && k > 0) return -multPos(-j, k);
		else return multPos(j, k);
	}
	
	/**
	 * @param n
	 * @param k
	 * @return int = n^k
	 */
	public static int expt(int n, int k) {
		if (k < 0) return 0;
		else if (k == 0) return 1;
		else {
			int product = n;
			for (int i = 1; i < k; i++) {
				//product = product * n;
				//product = mult(product, n);
			}
			return product;
		}
	}

}
