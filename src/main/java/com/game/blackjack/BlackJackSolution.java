package com.game.blackjack;

import com.game.blackjack.game.BlackJackGame;
import com.game.blackjack.model.Deck;
import com.game.blackjack.model.Player;
import com.game.blackjack.utils.Utilities;

import java.util.ArrayDeque;


public class BlackJackSolution
{
    public static void main( String[] args )
    {
        ArrayDeque<String> cardDeck = new ArrayDeque<>();

        if(args.length > 0){
          cardDeck = Utilities.validateInputFileAndCreateDeck(args[0]);
        }

        Deck deck = new Deck();

        if(cardDeck.isEmpty())
            deck.initializeShuffledCardDeck();
        else
            deck.setDeck(cardDeck);

        Player player1 = new Player();
        Player player2 = new Player();
        player1.setPlayerName("Sam");
        player2.setPlayerName("Dealer");

        BlackJackGame game = new BlackJackGame();

        game.playBlackJack(deck.getDeck(), player1, player2);

        Utilities.printGameResult(player1, player2);
    }





}
