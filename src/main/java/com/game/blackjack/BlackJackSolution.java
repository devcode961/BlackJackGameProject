package com.game.blackjack;

import com.game.blackjack.game.BlackJackGame;
import com.game.blackjack.model.Card;
import com.game.blackjack.model.Suit;

public class BlackJackSolution
{
    public static void main( String[] args )
    {
        BlackJackGame game = new BlackJackGame();
        game.playBlackJack();
    }
}
