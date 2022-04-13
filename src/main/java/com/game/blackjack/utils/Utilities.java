package com.game.blackjack.utils;

import com.game.blackjack.model.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayDeque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.game.blackjack.constants.GameConstants.*;

public class Utilities {

    public static ArrayDeque<String> validateInputFileAndCreateDeck(String filePath) {

        List<String> listCardDeck;
        ArrayDeque<String> cardDeck = new ArrayDeque<>();
        long validCardCount = 0;

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            String cardDeckString = stream.map(String::trim).collect(Collectors.joining());
            listCardDeck = Stream.of(cardDeckString.split(",")).map(String::trim).
                    collect(Collectors.toList());

            validCardCount = listCardDeck.stream().filter(card -> card.matches(CARD_REGEX_PATTERN)).
                    count();

            if (listCardDeck.size() == STANDARD_DECK_SIZE && validCardCount == STANDARD_DECK_SIZE) {
                System.out.println("Initialized deck of cards from input file\n CARD DECK : " + listCardDeck);
                cardDeck.addAll(listCardDeck);
            } else {
                System.out.println("One/More card values in input file not valid.Initializing deck of cards within program");
            }
        } catch (IOException ioException) {
            System.out.println("Exception while reading input file " + ioException.getMessage());
        } catch (Exception exception) {
            System.out.println("Exception while processing input file " + exception.getMessage());
        }
        return cardDeck;
    }

    public static void calculateHandValue(Player player) {
        int totalHandValue = 0;
        for (String card : player.getPlayerHand()) {
            totalHandValue += CARD_FACE_VALUE_MAP.get(card.substring(1));
        }
        player.setCurrentHandValue(totalHandValue);
    }

    public static void printGameResult(Player sam, Player dealer) {
        String winnerName = (sam.isWinner()) ? sam.getPlayerName() : dealer.getPlayerName();
        System.out.println(winnerName);
        System.out.println(sam.getPlayerName() + ": " + sam.getPlayerHand());
        System.out.println(dealer.getPlayerName() + ": " + dealer.getPlayerHand());
    }

    public static ArrayDeque<String> createDeckFromCardString(String cardsList){
        return Stream.of(cardsList.split(",")).map(String::trim).collect(Collectors.toCollection(ArrayDeque::new));
    }
}
