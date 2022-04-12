package com.game.blackjack.game;

import com.game.blackjack.Utilities;
import com.game.blackjack.model.Player;
import java.util.ArrayDeque;

public class BlackJackGame {

    public void playBlackJack(ArrayDeque<String> deck, Player sam, Player dealer) {

        sam.getPlayerHand().add(deck.pop());
        dealer.getPlayerHand().add(deck.pop());
        sam.getPlayerHand().add(deck.pop());
        dealer.getPlayerHand().add(deck.pop());

        Utilities.getHandValue(sam);
        Utilities.getHandValue(dealer);

        if (sam.getCurrentHandValue() == 21) {
            sam.setWinner(true);
            return;
        }
        else if(dealer.getCurrentHandValue() == 21){
            dealer.setWinner(true);
            return;
        }
        else if (dealer.getCurrentHandValue() == 22 && sam.getCurrentHandValue() == 22) {
            dealer.setWinner(true);
            return;
        }

        //Neither player turned out to be winner in initial draw.
        //Sam starts drawing cards
        do{
            sam.getPlayerHand().add(deck.pop());
            Utilities.getHandValue(sam);
        }
        while (sam.getCurrentHandValue() < 17);

        decideWinner(sam, dealer);

        if(!dealer.isWinner()){
            //Value of Sam's hand is 17 or more , Sam stops drawing cards.
            //Now dealer starts drawing cards from deck
            do{
                dealer.getPlayerHand().add(deck.pop());
                Utilities.getHandValue(dealer);
            }
            while(dealer.getCurrentHandValue()<=sam.getCurrentHandValue());
            decideWinner(dealer, sam);
            if(!sam.isWinner() && !dealer.isWinner()){
                dealer.setWinner(true);
            }
        }
    }

    public static void decideWinner(Player player1, Player player2){
        if(player1.getCurrentHandValue() > 21){
            player1.setLoser(true);
            player2.setWinner(true);
        }
    }

}