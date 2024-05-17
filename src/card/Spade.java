package card;

public class Spade extends Card{
	private char suit;
	public Spade(int number) {
		super(number);
		this.suit = 's';
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
	public String toString() {
		return "number: " + super.getNumber() + ", Suit:" + this.suit;
	}
}
