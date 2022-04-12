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

        if (player2.getCurrentHandValue() >= 21 || player1.getCurrentHandValue() == 22) {
            player2.setWinner(true);
            return player2;
        }
        if (player1.getCurrentHandValue() == 21) {
            player1.setWinner(true);
            return player1;
        }

        while (player1.getCurrentHandValue() < 17) {
            player1.getPlayerHand().add(deck.pop());
            Utilities.getHandValue(player1);
        }

        if (player1.getCurrentHandValue() == 21) {
            player1.setWinner(true);
            return player1;
        }
        if (player1.getCurrentHandValue() > 21) {
            player2.setWinner(true);
            return player2;
        }

        while(player2.getCurrentHandValue()<=player1.getCurrentHandValue()){
                player2.getPlayerHand().add(deck.pop());
                Utilities.getHandValue(player2);
        }

        if (player2.getCurrentHandValue() == 21) {
            player2.setWinner(true);
            return player2;
        }
        if (player2.getCurrentHandValue() > 21) {
            player1.setWinner(true);
            return player1;
        }
     return player2;
    }
}