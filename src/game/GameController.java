package game;

import deck.Deck;

import score.Score;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import Window.GameWindow;
import card.*;
public class GameController {
	
	private GameController id; // id of controller himself
	public GameWindow gameWindow;
	private int remainingJoker;
	private Score currentPoints;
	public Deck CardDeck;
	public Hand currentHand;
	public Hand drawerHand;
	
	public GameController() {
		this.currentPoints = new Score();
		this.remainingJoker = 3;
		// Initialize Deck and Hand Objects
		CardDeck = new Deck();
		currentHand = new Hand();
		drawerHand = new Hand(); // Drawing cards
		this.id = this;
	}
	public void start() {
		this.gameWindow = new GameWindow();
		
		//Update Score on the screen 
		this.gameWindow.UpdateScore(currentPoints.getScore());
		// We fill the Hand with full of card and print it on the screen
		for( int i =1; i<=4; i++) {
			Card var = CardDeck.PickFirstCard();
			currentHand.addCard(var);
		}
		this.gameWindow.displayHand(currentHand);
		
		
		// Game loop
        SwingWorker<Void, Void> gameLoopWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
            	boolean gameState = true;
                while (gameState) {
                	// if we use joker we hide our last card and take another card
        			if( id.gameWindow.getUseJoker() == true && remainingJoker > 0) {
        				System.out.println("You just have used one Joker !");
        				System.out.println(id.remainingJoker +" Joker remaining");
        				id.remainingJoker --;
        				drawerHand.addCard(currentHand.hideLastCard()); // Hide LastCard
        				currentHand.addCard(CardDeck.PickFirstCard());
        			
        				//Window updates
        				SwingUtilities.invokeLater(()->{
        					id.gameWindow.addCard(currentHand.getCard(3), 4);
        					id.gameWindow.ShowHideCard(drawerHand.getCard(drawerHand.getHandSize()-1));
        					id.gameWindow.discardJoker(remainingJoker);
                    	});
        				
        				id.gameWindow.setUseJoker(false);
        			}
        			
        			// if we use a draw Card, we discard the last card and take a card at the top of the drawer
        			if(id.gameWindow.getUseDrawCard() == true) {
        				if(id.drawerHand.getHandSize() > 0) {
        					System.out.println("You just have take on of your draw Cards ! ");
        					Card var = id.drawerHand.getCard(id.drawerHand.getHandSize()-1);

        					id.currentHand.discardCard(id.currentHand.getCard(3)); // discard last hand card
        					id.currentHand.addCard(var);
        					id.drawerHand.discardCard(var); // draw Car discard
        					// DrawerHand Window update
            				SwingUtilities.invokeLater(()->{
            							
            					if(id.drawerHand.getHandSize()> 0) {
            						id.gameWindow.ShowHideCard(id.drawerHand.getCard(id.drawerHand.getHandSize()-1));
            					}else {
            						id.gameWindow.ShowHideCard(null);
            					}
            					id.gameWindow.displayHand(currentHand);
                        	});
        				}
        				id.gameWindow.setUseDrawCard(false);
        			}
   
        			// if we continue, if we can we got points either the last card is discard and we take another one
        			if(id.gameWindow.getContinue() == true) {
        				if(id.CardDeck.getDeckSize() > 0) {
	        				int pointState = handlePointScore(currentHand);
	        				
	        				// we score 5 points
	        				if(pointState == 1 ) {
	        					id.currentPoints.ScoreFivePoint();
	        					//Discarded update
	            				SwingUtilities.invokeLater(()->{
	            					id.gameWindow.showDiscardCard(currentHand.getCard(3));
	                        	});
	        					// delete all the hand cards
	        					for(int i=0; i <4;i++) {
	        						currentHand.discardCard(currentHand.getCard(0));
	        					}
	        					//pick 4 other cards
	        					for(int i=0; i< 4;i++) {
	        						if(currentHand.getHandSize() < 4) {
	        							currentHand.addCard(CardDeck.PickFirstCard());
	        						}
	        					}
	        				}else if(pointState == 0) { // we score 2 points
	        					id.currentPoints.ScoreTwoPoint();
	        					
	        					
	        					//Discarded update
	            				SwingUtilities.invokeLater(()->{
	            					id.gameWindow.showDiscardCard(currentHand.getCard(2));
	                        	});
	            				// delete two middle hand cards
	        					currentHand.discardCard(currentHand.getCard(1));
	        					currentHand.discardCard(currentHand.getCard(1));
	        					
	        					// pick 2 other cards
	        					if(currentHand.getHandSize() < 4) {
	        						currentHand.addCard(CardDeck.PickFirstCard());
	        						currentHand.addCard(CardDeck.PickFirstCard());
	        					}
	        				}else { // we score 0 points
	        					//Discarded update
	            				SwingUtilities.invokeLater(()->{
	            					id.gameWindow.showDiscardCard(currentHand.getCard(3));
	                        	});
	        					//delete last Card
	        					currentHand.discardCard(currentHand.getCard(3));
	        					if(currentHand.getHandSize() < 4) {
	        						currentHand.addCard(CardDeck.PickFirstCard());
	        					}
	        				}
	        				
	        				//Hand update
	        				SwingUtilities.invokeLater(()->{
	        					id.gameWindow.displayHand(currentHand);
	                    	});
        				}
        				id.gameWindow.setContinue(false);
        			}
                            	
                	//Update current score
                	SwingUtilities.invokeLater(()->{
                		gameWindow.UpdateScore(currentPoints.getScore());
                	});
        			// check if the game continue or not
                	System.out.println(id.CardDeck.getDeckSize());
        			if(CardDeck.getDeckSize() <1 && drawerHand.getHandSize() < 1) {
        				if(id.currentHand.getHandSize() <= 4) {
        					int checkLastScore = id.handlePointScore(currentHand);
        					if(checkLastScore == 0){
            					id.currentPoints.ScoreTwoPoint();           					
            				}else if(checkLastScore == 1){
            					id.currentPoints.ScoreFivePoint();
            				}
        				}
        				gameState = false; 
        				id.stop();
        			}
        			
                }
                return null;
            }
        };
        gameLoopWorker.execute();
	}
	
	public void stop() {
		// Store the Score if it is better than last High Score
		String filePath = System.getProperty("user.dir");
		filePath += "/src/resources/Score.txt";
		Score compare = new Score();
		compare.getScoreFromFile(filePath);
		if(compare.getScore() < currentPoints.getScore()) {
			this.currentPoints.storeScoreInFile(filePath);
		}
		//Window updates
		SwingUtilities.invokeLater(()->{
			id.gameWindow.showEndScreen(id.currentPoints.getScore(), compare.getScore());
    	});
	}
	
	//This method check if we can score point 
	private int handlePointScore(Hand varTest) {
		Card first = varTest.getCard(0);
		//5 points
		if(first.getNumber() == varTest.getCard(3).getNumber()){
			return 1;
		}
		//2 points
		if( first.hasSameSuit(varTest.getCard(3))) {
			return 0;
		}
		// 0 Points
		
		return -1;
	}
	public int getLastJoker() {
		return this.remainingJoker;
	}
}
