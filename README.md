# LP2A P2024: Project DeadLine __May 17th 2024__
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
