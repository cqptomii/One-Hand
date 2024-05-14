package deck;

import java.util.*;
import card.*;
public class Deck {
	private List <Card> cardDeck;
	Deck(){
		this.cardDeck = new ArrayList<Card>();
		for( int i=0; i < 13; i++) {
			this.cardDeck.add(new Club(i));
			this.cardDeck.add(new Diamond(i));
			this.cardDeck.add(new Hearts(i));
			this.cardDeck.add(new Spade(i));
		}
		this.deckShuffle();
	}
	private void deckShuffle() {
		Random rand = new Random();
		
		int randIndex;
		List <Card> storage = new ArrayList<Card>();
		while(this.cardDeck.size() >0) {
			randIndex = rand.nextInt(this.cardDeck.size());
			storage.add(this.cardDeck.get(randIndex));
			this.cardDeck.remove(this.cardDeck.get(randIndex));
		}   
		this.cardDeck = storage;
	}
	public Card PickFirstCard() {
		int deckIndex = this.cardDeck.size();
;		if(deckIndex > 0) {
			cardDeck.remove(deckIndex);
			return cardDeck.get(deckIndex);
		}
		return null;
	}
}
