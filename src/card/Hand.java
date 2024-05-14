package card;
import java.util.*;

public class Hand {
	private List <Card> currentHand;
	
	public Hand() {
		this.currentHand = new ArrayList<Card>();
	}
	public void discardCard(Card delete) {
		this.currentHand.remove(delete);
	}
	public void addCard(Card add) {
		if(this.currentHand.size() < 4) {
			this.currentHand.add(add);
		}
	}
	public Card hideLastCard() {
		Card hiding = this.currentHand.get(this.currentHand.size());
		this.currentHand.remove(this.currentHand.size());
		return hiding;
	}
	
}
