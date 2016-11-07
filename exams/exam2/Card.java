package exam2;

public class Card {

	private int value;
	private String suit;
	private boolean available;
	
	public Card(int v, String s) {
		this.value = v;
		this.suit = s;
		this.available = true;
	}
	
	public String toString() {
		return "Card [" + this.value + ", " + this.suit + "]";
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getSuit() {
		return this.suit;
	}
	
	public boolean getAvailable() {
		return this.available;
	}
	
	public void setAvailable(boolean a) {
		this.available = a;
	}
	
}
