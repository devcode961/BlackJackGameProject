package com.game.blackjack;



import com.game.blackjack.model.Player;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utilities {

    private static final Logger logger = Logger.getLogger(Utilities.class.getName());

    private static final String CARD_REGEX_PATTERN  = "^[C|D|H|S]([A|K|J|Q]|[2-9]|10)$";

    public static final List<String> suiteList = Arrays.asList("C","D","S","H");

    public final static Map<String, Integer> cardFaceValueMap = Stream.of(new Object[][] {
            { "2", 2 },
            { "3", 3 },
            { "4", 4 },
            { "5", 5 },
            { "6", 6 },
            { "7", 7 },
            { "8", 8 },
            { "9", 9 },
            { "10",10 },
            { "A", 11 },//A for Ace
            { "J", 10 },//J for Jack
            { "Q", 10 },//Q for Queen
            { "K", 10},//K for King
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));


    public static ArrayDeque<String> validateInputFileAndCreateDeck(String filePath)  {

        //Set<String> listCardDeck;
        List<String> listCardDeck;
        ArrayDeque<String> cardDeck = new ArrayDeque<>();

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            String cardDeckString = stream.map(String::trim).collect(Collectors.joining());
            listCardDeck = Stream.of(cardDeckString.split(",")).map(String::trim).collect(Collectors.toList());
            if(validateCardValues(listCardDeck)){
                logger.log(Level.INFO, "Initialized a new deck of cards from input file as \n CardDeck "+listCardDeck);
                cardDeck.addAll(listCardDeck);
            }
        }
        catch(IOException ioException){
          logger.log(Level.SEVERE, "Error in reading input file. File may not exist or is not a valid file", ioException);
          cardDeck.clear();
        }
        return cardDeck;
    }

    private static boolean validateCardValues(List<String> cardSet){
        cardSet = cardSet.stream().filter(card -> card.matches(CARD_REGEX_PATTERN)).collect(Collectors.toList());
        return cardSet.size() == 52;
    }

    public static int getHandValue(Player player){
        int totalHandValue = 0;
        for(String card : player.getPlayerHand()){
            totalHandValue+= cardFaceValueMap.get(card.substring(1));
        }
        player.setCurrentHandValue(totalHandValue);
        return totalHandValue;
    }

    public static void printGameResult(Player sam, Player dealer){
        String winnerName = (sam.isWinner()) ? sam.getPlayerName() : dealer.getPlayerName();
        System.out.println(winnerName);
        System.out.println(sam.getPlayerName()+": "+sam.getPlayerHand());
        System.out.println(dealer.getPlayerName()+": "+dealer.getPlayerHand());
    }
}
