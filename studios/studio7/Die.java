package studio7;

public class Die {

	private int n;
	
	public Die(int n) {
		this.n = n;
	}
	
	/**
	 * 
	 * @return random integer in the range 1, 2, ..., n
	 */
	public int throwDie() {
		return (int)(Math.random() * this.n) + 1;
	}
	
}
