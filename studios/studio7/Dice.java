package studio7;

public class Dice {

	private int side;
	
	public Dice(int side) {
		this.side = side;
	}
	
	public int throwDice() {
		return (int)(Math.random() * this.side) + 1;
	}
	
}
