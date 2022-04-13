package com.game.blackjack.game;

import com.game.blackjack.model.Player;
import com.game.blackjack.utils.Utilities;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayDeque;


class BlackJackGameTest {

    Player sam, dealer;
    BlackJackGame blackJackGame;

    @BeforeEach
    void setUp() {
        sam = new Player();
        sam.setPlayerName("Sam");
        dealer = new Player();
        dealer.setPlayerName("Dealer");
        blackJackGame = new BlackJackGame();

    }

    @AfterEach
    void tearDown() {
        sam.getPlayerHand().clear();
        sam.setCurrentHandValue(0);
        sam.setWinner(false);
        dealer.getPlayerHand().clear();
        dealer.setCurrentHandValue(0);
        dealer.setWinner(false);
    }

    @Test
    void testWinner_Dealer() {
        String deckInput = "SQ, H7, D4, S2, D9, D7, H5, C10, H4, D8, CK, S6, C3, DA, SA, C8, HA, CJ, H6, D2, S8, CA, S4, DK, H3, CQ, S3, S9, DJ, C4, S5, C7, HK, D5, HJ, H9, HQ, C5, S10, SJ, H2, H8, C2, D6, D10, C6, DQ, S7, H10, SK, D3, C9";
        ArrayDeque<String> deck = Utilities.createDeckFromCardString(deckInput);
        System.out.println(deck);
        blackJackGame.playBlackJack(deck, sam, dealer);
        Assertions.assertEquals(9, dealer.getCurrentHandValue());
        Assertions.assertEquals(23, sam.getCurrentHandValue());
        Assertions.assertTrue(dealer.isWinner());
        Assertions.assertFalse(sam.isWinner());

    }

    @Test
    void testWinner_Sam() {
        String deckInput = "C3, H5, DQ, HQ, S4, H2, C6, C10, S5, DJ, H8, D3, C7, HA, D9, S2, SQ, C4, H6, D5, SK, S3, H4, C2, D8, C8, S6, D6, HK, D4, S8, D7, S7, SA, H10, DK, DA, H7, CK, D10, H3, C5, CQ, CA, S9, CJ, S10, HJ, SJ, C9, D2, H9";
        ArrayDeque<String> deck = Utilities.createDeckFromCardString(deckInput);
        System.out.println(deck);
        blackJackGame.playBlackJack(deck, sam, dealer);
        Assertions.assertEquals(23, dealer.getCurrentHandValue());
        Assertions.assertEquals(17, sam.getCurrentHandValue());
        Assertions.assertTrue(sam.isWinner());
        Assertions.assertFalse(dealer.isWinner());

    }

    @Test
    void testWinner_Sam_When_Sam_Starts_With_BlackJack() {
        String deckInput = "CA, H5, DQ, HQ, S4, H2, C6, C10, S5, DJ, H8, D3, C7, HA, D9, S2, SQ, C4, H6, D5, SK, S3, H4, C2, D8, C8, S6, D6, HK, D4, S8, D7, S7, SA, H10, DK, DA, H7, CK, D10, H3, C5, CQ, C3, S9, CJ, S10, HJ, SJ, C9, D2, H9";
        ArrayDeque<String> deck = Utilities.createDeckFromCardString(deckInput);
        System.out.println(deck);
        blackJackGame.playBlackJack(deck, sam, dealer);
        Assertions.assertEquals(15, dealer.getCurrentHandValue());
        Assertions.assertEquals(21, sam.getCurrentHandValue());
        Assertions.assertEquals(2, dealer.getPlayerHand().size());
        Assertions.assertEquals(2, sam.getPlayerHand().size());
        Assertions.assertTrue(sam.isWinner());
        Assertions.assertFalse(dealer.isWinner());
    }

    @Test
    void testWinner_Dealer_When_Dealer_Starts_With_BlackJack() {
        String deckInput = "H5, CA, DQ, HQ, S4, H2, C6, C10, S5, DJ, H8, D3, C7, HA, D9, S2, SQ, C4, H6, D5, SK, S3, H4, C2, D8, C8, S6, D6, HK, D4, S8, D7, S7, SA, H10, DK, DA, H7, CK, D10, H3, C5, CQ, C3, S9, CJ, S10, HJ, SJ, C9, D2, H9";
        ArrayDeque<String> deck = Utilities.createDeckFromCardString(deckInput);
        System.out.println(deck);
        blackJackGame.playBlackJack(deck, sam, dealer);
        Assertions.assertEquals(21, dealer.getCurrentHandValue());
        Assertions.assertEquals(15, sam.getCurrentHandValue());
        Assertions.assertEquals(2, dealer.getPlayerHand().size());
        Assertions.assertEquals(2, sam.getPlayerHand().size());
        Assertions.assertFalse(sam.isWinner());
        Assertions.assertTrue(dealer.isWinner());

    }

    @Test
    void testWinner_Sam_When_Both_Starts_With_BlackJack() {
        String deckInput = "CA, HA, DQ, HQ, S4, H2, C6, C10, S5, DJ, H8, D3, C7, H5, D9, S2, SQ, C4, H6, D5, SK, S3, H4, C2, D8, C8, S6, D6, HK, D4, S8, D7, S7, SA, H10, DK, DA, H7, CK, D10, H3, C5, CQ, C3, S9, CJ, S10, HJ, SJ, C9, D2, H9";
        ArrayDeque<String> deck = Utilities.createDeckFromCardString(deckInput);
        System.out.println(deck);
        blackJackGame.playBlackJack(deck, sam, dealer);
        Assertions.assertEquals(21, dealer.getCurrentHandValue());
        Assertions.assertEquals(21, sam.getCurrentHandValue());
        Assertions.assertEquals(2, dealer.getPlayerHand().size());
        Assertions.assertEquals(2, sam.getPlayerHand().size());
        Assertions.assertTrue(sam.isWinner());
        Assertions.assertFalse(dealer.isWinner());
    }

    @Test
    void testWinner_Dealer_When_Both_Starts_With_22() {
        String deckInput = "CA, HA, SA, DA, S4, H2, C6, C10, S5, DJ, H8, D3, C7, H5, D9, S2, SQ, C4, H6, D5, SK, S3, H4, C2, D8, C8, S6, D6, HK, D4, S8, D7, S7, DQ, H10, DK, HQ, H7, CK, D10, H3, C5, CQ, C3, S9, CJ, S10, HJ, SJ, C9, D2, H9";
        ArrayDeque<String> deck = Utilities.createDeckFromCardString(deckInput);
        System.out.println(deck);
        blackJackGame.playBlackJack(deck, sam, dealer);
        Assertions.assertEquals(22, dealer.getCurrentHandValue());
        Assertions.assertEquals(22, sam.getCurrentHandValue());
        Assertions.assertEquals(2, dealer.getPlayerHand().size());
        Assertions.assertEquals(2, sam.getPlayerHand().size());
        Assertions.assertTrue(dealer.isWinner());
        Assertions.assertFalse(sam.isWinner());
    }
}