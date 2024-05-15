package game;

import deck.Deck;

import java.util.*;

import Window.GameWindow;
import card.*;
public class GameController {
	public GameWindow gameWindow;
	private int remainingJoker;
	private int currentPoint;
	
	public GameController() {
		this.currentPoint = 0;
		this.remainingJoker = 3;
	}
	public void start() {
		// intialize Deck et Hand Objects
		Deck CardDeck = new Deck();
		Hand currentHand = new Hand();
		Hand drawerHand = new Hand(); // Drawing cards
		this.gameWindow = new GameWindow();
		boolean gameState = true;
		
		// We fill the Hand with full of card and print it on the screen
		for( int i =1; i<=4; i++) {
			Card var = CardDeck.PickFirstCard();
			currentHand.addCard(var);
			gameWindow.addCard(currentHand.getCard(i-1), i);
		}
		/**
		// Game loop
		while (gameState == true) {
			
			// if we use joker we hide our last card and take another card
			if(this.gameWindow.getUseJoker() == true) {
				drawerHand.addCard(currentHand.hideLastCard()); // Hide LastCard
				currentHand.addCard(CardDeck.PickFirstCard());
				
				//Window updates
				this.gameWindow.addCard(currentHand.getCard(3), 4);
				this.gameWindow.hideCard(drawerHand.getCard(drawerHand.getHandSize()-1));
				this.gameWindow.setUseJoker(false);
			}
			// if we continue, if we can we got points either the last card is discard and we take another one
			if(this.gameWindow.getContinue() == true) {
				
				int pointState = handlePointScore(currentHand);
				
				// we score 5 points
				if(pointState == 1 ) {
					this.scoreFivePoints();
					// delete all the hand cards
					for(int i=0; i <4;i++) {
						currentHand.discardCard(currentHand.getCard(i));
					}
					//pick 4 other cards
					for(int i=0; i< 4;i++) {
						if(currentHand.getHandSize() < 4) {
							currentHand.addCard(CardDeck.PickFirstCard());
							this.gameWindow.addCard(currentHand.getCard(i), i+1); // Window update
						}
					}
					
				
				}else if(pointState == 0) { // we score 2 points
					this.scoreTwoPoints();
					
					// delete two middle hand cards
					currentHand.discardCard(currentHand.getCard(1));
					currentHand.discardCard(currentHand.getCard(2));
					
					// pick 2 other cards
					if(currentHand.getHandSize() < 4) {
						currentHand.addCard(CardDeck.PickFirstCard());
						currentHand.addCard(CardDeck.PickFirstCard());
					}
					
					for(int i = 0;i<4;i++) {
						this.gameWindow.addCard(currentHand.getCard(i), i+1); // Update window
					}
				}else { // we score 0 points
					//delete last Card
					currentHand.discardCard(currentHand.getCard(3));
					if(currentHand.getHandSize() < 4) {
						currentHand.addCard(CardDeck.PickFirstCard());
						this.gameWindow.addCard(currentHand.getCard(3), 4);
					}
				}
			
			}
			
			//Update current score
			
			// check if the game continue or not
			if(CardDeck.getDeckSize() <1 && currentHand.getHandSize() < 4 && drawerHand.getHandSize() < 1) {
				gameState = false;
			}
		}
		*/
	}
	public void stop() {
		
	}
	
	//This method check if we can score point 
	private int handlePointScore(Hand varTest) {
		List <Card> currentHand = varTest.getCurrentHand();
		Card first = currentHand.get(0);
		//5 points
		if(first.getNumber() == currentHand.get(currentHand.size()-1).getNumber()){
			return 1;
		}
		//2 points
		if( first.hasSameSuit(currentHand.get(3))) {
			return 0;
		}
		// 0 Points
		
		return -1;
	}
	// This method check if the game should continue or not 
	// The game continue until there are no cards left in the drawerHand and in the decks
	public void updateGameState() {
		
	}
	private void scoreFivePoints() {
		// add points 
		this.currentPoint += 5;
	}
	private void scoreTwoPoints() {
		// add points 
		this.currentPoint += 2;
	}
	public int getScore() {
		return this.currentPoint;
	}
	public void useJoker() {
		if(getLastJoker() > 0) {
		
			this.remainingJoker--;
			// hide last Card
			
			// get another Card at the top of the Hand
		}
	}
	public int getLastJoker() {
		return this.remainingJoker;
	}
}
