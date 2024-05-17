package card;

public abstract class Card {
	private int number;
	
	public Card(int number) {
		if(number > 0 && number <=13) {
			this.number = number;
		}
	}
	
	public boolean numberIsEqual(Card e) {
		if(e != null) {
			if(e.number == this.number) {
				return true;
			}
		}
		return false;
	}
	
	public int getNumber() {
		return this.number;
	}
	public void setNumber(int value) {
		if (value > 0 && value <13) {
			this.number = value;
		}
	}
	public abstract char getSuit();
	public abstract boolean hasSameSuit(Card e);
	public String toString() {
		return "number :" + this.number;
	}
}
