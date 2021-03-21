# Blackjack

## Introduction
A basic console Blackjack game implemented in Java.

## Game Information
Game can be played by 1 to 5 players plus the computer dealer. Each player in turn has the opportunity to "twist" (be dealt an additional card) as many times as they wish until they are "bust". The player is bust when the cards in their hamd totals 22 or over. Face cards count as 10, aces count as either 1 or 11, depending on which is most advantageous to the player. The dealer's first card is always visible to every player. Choices are made by following the instructions output to the console and typing the required responses.

The Dealer plays last and will always twist when its total is 16 or less and will not take any more cards if the total is above 16. If the dealer is bust, all players not bust are considered to have won. If the dealer is not bust, the player (including the dealer) with the highest total not exceeding 21 is the winner.

## House rules
This game is conducted with only one standard deck of cards, meaning that each individual card can only be dealt to one player - e.g. there are only 4 aces, one from each suit, and when they have been dealt, another ace cannot occur.

In the event of a draw with the dealer not being bust, the winner is the player with the highest individual card. For these purposes, the highest ranking cards in order are: ace, king, queen, jack and then the rest of the cards in descending numerical order. If this comparison does not produce a winner, the suits of the highest cards are compared. This is not standard in most Blackjack games and is included only to remove the possibility of a draw when the dealer is still in play. The suits are ranked highest to lowest in the following order: Spades, Hearts, Diamonds, Clubs.
