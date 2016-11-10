package exam2;

import java.util.HashSet;
import java.util.Set;

public class CardSuit {

	private String suit;
	private Card[] cards;
//	private Set<Card> cards;
	
	public CardSuit(String s) {
		this.suit = s;
		this.cards = new Card[4];
		for (int i = 0; i < this.cards.length; i++) {
			this.cards[i] = new Card(i + 1, s);
		}
//		this.cards = new HashSet<Card>();
//		for (int i = 0; i < 4; i++) {
//			Card c = new Card(i + 1, s);
//			cards.add(c);
//		}
	}
	
	public String getSuit() {
		return this.suit;
	}
	
	public int numDealt() {
		int count = 0;
		for (int i = 0; i < this.cards.length; i++) {
			if (this.cards[i].getAvailable() == false) count++;
		}
		return count;
	}
	
	public Card deal() {		
		if (this.cards[0].getAvailable()) return this.cards[0];
		else {
			if (this.cards[1].getAvailable()) return this.cards[1];
			else {
				if (this.cards[2].getAvailable()) return this.cards[2];
				else return this.cards[3];
			}
		}
	}
	
	public void reset() {
		for (int i = 0; i < this.cards.length; i++) {
			this.cards[i].setAvailable(true);
		}
	}
	
}
