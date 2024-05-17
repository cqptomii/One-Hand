package deck;

import java.util.*;
import card.*;
public class Deck {
	private List <Card> cardDeck;
	public Deck(){
		this.cardDeck = new ArrayList<Card>();
		for( int i=1; i <= 13; i++) {
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
		while(this.cardDeck.size() > 0) {
			// entre 0 et size-1
			randIndex = rand.nextInt(this.cardDeck.size());
			storage.add(this.cardDeck.get(randIndex));
			this.cardDeck.remove(this.cardDeck.get(randIndex));
		}   
		this.cardDeck = storage;
	}
	public Card PickFirstCard() {
		int deckIndex = this.cardDeck.size()-1;
;		if(deckIndex >= 0) {
			Card var = cardDeck.get(deckIndex);
			cardDeck.remove(deckIndex);
			return var;
		}
		return null;
	}
	public int getDeckSize() {
		return this.cardDeck.size();
	}
}
