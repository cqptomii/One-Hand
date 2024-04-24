package game;

public class GameController {
	private int remainingJoker;
	private int pointScored;
	
	public GameController() {
		this.remainingJoker = 3;
		this.pointScored = 0;
	}
	public int getLastJoker() {
		return remainingJoker;
	}
	public int getScore() {
		return pointScored;
	}
	
	public void start() {
		
	}
	public void stop() {
		
	}
	
	public void scoreFivePoints() {
		// discard all the hand 
		
		// add points 
		this.pointScored += 5;
	}
	public void scoreTwoPoints() {
		// discard middle of  the hand 
		
		// add points 
		this.pointScored += 2;
	}
	
	public void useJoker() {
		// hide last Card
		
		// get another Card at the top of the Hand
	}
}
