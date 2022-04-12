package com.game.blackjack;

import com.game.blackjack.model.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utilities {

    static final Logger logger = Logger.getLogger(Utilities.class.getName());

    private final static Map<String, Integer> cardFaceValueMap = Stream.of(new Object[][] {
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
            { "Q", 10 },//Q fro Queen
            { "K", 10},//K for King
    }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));


    public static int calculateHandValue(){
        return 0;
    }

    public static void checkInputFileValid(String filePath) {

        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.map(String::trim).collect(Collectors.joining());
        }
        catch(IOException ioException){
          logger.log(Level.SEVERE, "Error in reading input file", ioException.getCause());
        }
    }

    public static int getHandValue(Player player){
        int totalHandValue = 0;
        for(String card : player.getPlayerHand()){
            totalHandValue+= cardFaceValueMap.get(card.substring(1));
        }
        player.setCurrentHandValue(totalHandValue);
        return totalHandValue;
    }
}
