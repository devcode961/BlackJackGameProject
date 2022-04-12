package com.game.blackjack;

import com.game.blackjack.game.BlackJackGame;
import com.game.blackjack.model.Deck;
import com.game.blackjack.model.Player;

public class BlackJackSolution
{
    public static void main( String[] args )
    {
        if(args.length==1){
            Utilities.checkInputFileValid(args[0]);
        }
        Deck deck = new Deck();

        deck.initializeShuffledCardDeck();

        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPlayerName("Sam");
        player2.setPlayerName("Dealer");
        BlackJackGame game = new BlackJackGame();
        game.playBlackJack(deck.getDeck(), player1, player2);

        Utilities.printGameResult(player1, player2);
    }





}
