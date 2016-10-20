package studio7;

public class Fraction {

	private int n, d;
	
	public Fraction(int n, int d) {
		this.n = n;
		this.d = d;
	}
	
	/**
	 * 
	 * @return numerator
	 */
	public int getN() {
		return this.n;
	}
	
	/**
	 * 
	 * @return denominator
	 */
	public int getD() {
		return this.d;
	}
	
	/**
	 * 
	 * @param f (another fraction)
	 * @return sum of fraction and f
	 */
	public Fraction sumFraction(Fraction f) {
		int newN = (this.n * f.getD()) + (this.d * f.getN());
		int newD = this.d * f.getD();
		
		return new Fraction(newN, newD);
	}
	
	/**
	 * 
	 * @param f (another fraction)
	 * @return product of fraction and f
	 */
	public Fraction productFraction(Fraction f) {
		int newN = this.n * f.getN();
		int newD = this.d * f.getD();
		
		return new Fraction(newN, newD);
	}
	
	/**
	 * 
	 * @return reciprocal of fraction
	 */
	public Fraction reciprocal() {
		int newN = this.d;
		int newD = this.n;
		
		return new Fraction(newN, newD);
	}
	
	/**
	 * 
	 * @return simplified fraction
	 */
	public Fraction simplify() {
		int newN = this.n;
		int newD = this.d;
		
		if (this.n >= this.d) {
			for (int i = this.d; i > 1; i--) {
				if (this.d % i == 0 && this.n % i == 0) {
					newN = newN / i;
					newD = newD / i;
				}
			}
		}
		
		else {
			for (int i = this.n; i > 1; i--) {
				if (this.d % i == 0 && this.n % i == 0) {
					newN = newN / i;
					newD = newD / i;
				}
			}
		}
		
		return new Fraction(newN, newD);
	}
}
