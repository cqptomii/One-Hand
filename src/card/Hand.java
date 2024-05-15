package card;
import java.util.*;

public class Hand {
	private List <Card> currentHand;
	
	public Hand() {
		this.currentHand = new ArrayList<Card>();
	}
	public void discardCard(Card delete) {
		if(this.currentHand.size() > 0) {
			this.currentHand.remove(delete);
		}
	}
	public void addCard(Card add) {
		if(this.currentHand.size() < 4) {
			this.currentHand.add(add);
		}
	}
	public Card hideLastCard() {
		int size = this.currentHand.size();
		if(size >0) {
			Card hiding = this.currentHand.get(size-1);
			this.currentHand.remove(size-1);
			return hiding;
		}
		return null;
	}
	public Card getCard(int index) {
		return this.currentHand.get(index);
	}
	public List<Card> getCurrentHand(){
		return this.currentHand;
	}
	public int getHandSize() {
		return currentHand.size();
	}
	
}
