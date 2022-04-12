package com.game.blackjack.game;

import com.game.blackjack.Utilities;
import com.game.blackjack.model.Player;

import java.util.ArrayDeque;

public class BlackJackGame {

    public Player playBlackJack(ArrayDeque<String> deck, Player player1, Player player2) {

        player1.getPlayerHand().add(deck.pop());
        player2.getPlayerHand().add(deck.pop());
        player1.getPlayerHand().add(deck.pop());
        player2.getPlayerHand().add(deck.pop());

        Utilities.getHandValue(player1);
        Utilities.getHandValue(player2);

        if (player2.getCurrentHandValue() >= 21) {
            player2.setWinner(true);
            return player2;
        }
        if (player1.getCurrentHandValue() == 21) {
            player1.setWinner(true);
            return player1;
        }

        //Neither player turned out to be winner in initial draw.

        //Sam starts drawing cards
        while (player1.getCurrentHandValue() < 17) {
            player1.getPlayerHand().add(deck.pop());
            Utilities.getHandValue(player1);
        }

        while(player2.getCurrentHandValue()<=player1.getCurrentHandValue()){
                player2.getPlayerHand().add(deck.pop());
                Utilities.getHandValue(player2);
        }

        Player winner = checkWinner(player1, player2);

     return winner;
    }

    public static Player checkWinner(Player sam, Player dealer){

        Player winner = new Player();

        if (sam.getCurrentHandValue() < 21 && dealer.getCurrentHandValue() < 21) {
            dealer.setWinner(true);
            winner = dealer;
        }
        else if (sam.getCurrentHandValue() == 21 || dealer.getCurrentHandValue() > 21) {
            sam.setWinner(true);
            winner = sam;
        }
        else if(dealer.getCurrentHandValue() == 21 || sam.getCurrentHandValue() > 21){
            dealer.setWinner(true);
            winner = dealer;
        }
      return winner;
    }

}