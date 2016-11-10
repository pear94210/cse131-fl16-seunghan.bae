package exam2;

public class CardDeck {

	private CardSuit[] cardSuit;
	
	public CardDeck() {
		this.cardSuit = new CardSuit[4];
		
		cardSuit[0] = new CardSuit("heart");
		cardSuit[1] = new CardSuit("diamond");
		cardSuit[2] = new CardSuit("spade");
		cardSuit[3] = new CardSuit("club");
	}
	
}
