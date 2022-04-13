package com.game.blackjack.game;

import com.game.blackjack.utils.Utilities;
import com.game.blackjack.model.Player;

import java.util.ArrayDeque;

import static com.game.blackjack.constants.GameConstants.*;

public class BlackJackGame {

    public void playBlackJack(ArrayDeque<String> deck, Player sam, Player dealer) {

        sam.getPlayerHand().add(deck.pop());
        dealer.getPlayerHand().add(deck.pop());
        sam.getPlayerHand().add(deck.pop());
        dealer.getPlayerHand().add(deck.pop());

        Utilities.calculateHandValue(sam);
        Utilities.calculateHandValue(dealer);

        if (sam.getCurrentHandValue() == BLACK_JACK) {
            sam.setWinner(true);
            return;
        } else if (dealer.getCurrentHandValue() == BLACK_JACK) {
            dealer.setWinner(true);
            return;
        } else if (dealer.getCurrentHandValue() == INITIAL_VALUE_DEALER_WIN && sam.getCurrentHandValue() == INITIAL_VALUE_DEALER_WIN) {
            dealer.setWinner(true);
            return;
        }
        //Neither player turned out to be winner in initial draw.
        //Sam starts drawing cards
        do {
            sam.getPlayerHand().add(deck.pop());
            Utilities.calculateHandValue(sam);
        }
        while (sam.getCurrentHandValue() < SAM_STOP_VALUE);

        decideWinner(sam, dealer);

        if (!dealer.isWinner()) {
            //Value of Sam's hand is 17 or more , Sam stops drawing cards.
            //Now dealer starts drawing cards from deck
            do {
                dealer.getPlayerHand().add(deck.pop());
                Utilities.calculateHandValue(dealer);
            }
            while (dealer.getCurrentHandValue() <= sam.getCurrentHandValue());
            decideWinner(dealer, sam);

            if (!sam.isWinner() && !dealer.isWinner()) {
                dealer.setWinner(true);
            }
        }
    }

    private static void decideWinner(Player playerToCheck, Player opponent) {
        if (playerToCheck.getCurrentHandValue() > BLACK_JACK) {
            opponent.setWinner(true);
        }
    }
}