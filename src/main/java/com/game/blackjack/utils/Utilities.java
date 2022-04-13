package com.game.blackjack.utils;

import com.game.blackjack.model.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
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
                System.out.println("Initialized deck of cards from input file\n\nCARD DECK : " + listCardDeck + "\n\n");
                cardDeck.addAll(listCardDeck);
            } else {
                System.out.println("Could not initialize deck from input file.Reasons:");
                System.out.println("Input file does not have exact 52 cards OR One/More card values in input file not valid");
                System.out.println("Initializing deck of cards within program");
            }
        } catch (IOException ioException) {
            System.out.println("Exception while reading input file " + ioException +"\n");
        } catch (Exception exception) {
            System.out.println("Exception while processing input file " + exception+"\n");
        }
        return cardDeck;
    }

    public static void calculateHandValue(Player player) {
        int totalHandValue = 0;
        if (player.getPlayerHand() == null) return;
        for (String card : player.getPlayerHand()) {
            totalHandValue += CARD_FACE_VALUE_MAP.get(card.substring(1));
        }
        player.setCurrentHandValue(totalHandValue);
    }

    public static void printGameResult(Player sam, Player dealer) {
        System.out.println("Printing game result below : \n");
        String winnerName = (sam.isWinner()) ? sam.getPlayerName() : dealer.getPlayerName();
        System.out.println(winnerName);
        System.out.println(sam.getPlayerName() + ": " + String.join(", ", sam.getPlayerHand()));
        System.out.println(dealer.getPlayerName() + ": " + String.join(", ", dealer.getPlayerHand()));
    }

    public static ArrayDeque<String> createDeckFromCardString(String cardsList){
        return Stream.of(cardsList.split(",")).map(String::trim).collect(Collectors.toCollection(ArrayDeque::new));
    }
}
