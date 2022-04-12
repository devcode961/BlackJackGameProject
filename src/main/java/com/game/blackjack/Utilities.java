package com.game.blackjack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utilities {

    static final Logger logger = Logger.getLogger(Utilities.class.getName());

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
}
