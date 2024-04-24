package card;

public class Diamond extends Card {
	private char suit;
	public Diamond(int number) {
		super(number);
		this.suit = 'd';
	}
	public boolean hasSameSuit(Card e) {
		// TODO Auto-generated method stub
		if(e == null) {
			return false;
		}
		if( this.suit == e.getSuit()) {
			return true;
		}
		else {return false;}
	}
	@Override
	public char getSuit() {
		return this.suit;
	}
}
