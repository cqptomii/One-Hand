# Project Explanation
*This work must be performed by group of 2-3 students (if possible, in the same TP group)*.

For the evaluation, you are required to furnish: - **A video** *(3min length maximum)* presenting the project including a __presentation of the game rules__, __the conception choices__ you made and an overview of your __technical dificulties.__ 
- **A report**, including the conception of your software and an __**explanation**__ of the implementation choices. 
- The source code of all classes required for running your game.

### This year you have to reproduce a “Réussite” game called One Hand.
The rules are the following:
The game simply needs a complete shuFled 52-cards deck. Start by drawing a “hand” (4 cards) from the deck. Now take a look at this “hand”:
- If the first and last cards have the same number, the four cards are all discarded, and you score 5 points.
- If the first and last cards have the same suit (hearts ♥, diamonds ♦, clubs ♣ or spades ♠), the two cards in the middle of your hand are discarded and you score 2 points.
- If those two conditions are not met, hide the last card behind the third one and draw a new card from the deck to be the new first card of your hand.
Keep drawing cards if you cannot score points but you must always have 4 visible cards in your hand and the previous ones hidden behind the fourth one.
The Joker: if you cannot discard cards (no matching suits or numbers between the first and last visible cards of your hand) you can get rid of the two cards in the middle of your hand. **This is allowed only three times per game.** The __joker__ score __zero points__ sélectionné.

Explication here : https://youtu.be/jayssGEYyq4?si=_LqBLqJJpktNnMjQ

## Our Final Work 

![alt text](https://github.com/cqptomii/One-Hand/Pic/1.png)
![alt text](https://github.com/cqptomii/One-Hand/Pic/2.png)
![alt text](https://github.com/cqptomii/One-Hand/Pic/3.png)
# Our Work on images

# Context of the project:
The One Hand’s game project is a project coding in java, the goal is to reproduce the game called “One Hand”. It’s a game that playing with a complete shuffled 52-cards deck.
Conception:

To reproduce this game, we decided to separate the project between 6 packages: 
-	The “Window” to initialize the game window as needed, to display the score, the buttons, the cards, ...
-	The “card” to define the principe of a “card”, each symbols and the hand with which we can play
-	The “deck” to make the game authentic and random like in real life and no two games are the same
-	The “game” is the root of the game, thanks to this package the game can work
-	The “main” which only allows you to launch the game
-	The “Score” which allows you to count the points obtained by the player.
  
# Difficulties encountered:


The biggest difficulty was to make the link between the graphic window and the rest of the code, because it was not a part that we have really worked on in TD/TP so we had to find out more by ourself (and this part is really cool in my opinion).

Also, the set up of the Game loop was a bit difficult at the beginning because in it, we need to think about threads to interact with the game Window (a notion that we don’t really master so it was a bit strange for us). To do this loop we have needed to initialize a new thread because the Game loop could not be on the sale thread as the game window otherwise a white screen would appear (because the game loop was disturbing Window frame refresh.

Finally, the card bench was difficult to set up, not necessarily technically because it is just like the joker Card. But we have needed to take some choice within its implementation. So, to avoid too much complexity and to increase a little bit the difficulty of this game, we have decided to allow to take just the front card of the drawer. The main goal of this is to make players really thinking about Joker utility before using it. 


# Improvement clue:

Since the game is a game that is played alone and where the player has no real impact on the gameplay, it is difficult to implement new things. A variant with a 2 players mode (or with a bot) and more special cards which allow the player to make decisions are avenues for development.


# Experience analysis:

This project was very interesting because it allows us to practice a lot with OOP, in a real case of study. Moreover of that thanks to this project we have learn plenty of things on Swing Window management. 


# Conclusion:

This project was pleasant to do because it was both interesting and a little interactive, we could quickly see our evolution in the development of the game and it was a largely feasible subject given the time and difficulty given. This allowed us to familiarize ourselves with the Java language regarding extends/implements, windows, ... so we will be able to redo coding in Java in a more efficient way.
