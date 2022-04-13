package com.game.blackjack.constants;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameConstants {

    public static final String CARD_REGEX_PATTERN  = "^[C|D|H|S]([A|K|J|Q]|[2-9]|10)$";

    public static final int STANDARD_DECK_SIZE = 52;

    public static final int BLACK_JACK = 21;

    public static final int INITIAL_VALUE_DEALER_WIN = 22;

    public static final int SAM_STOP_VALUE = 17;

    //Initialized Suites as
    // C -> Club, D -> Diamond, H -> Heart, S -> Spade
    public static final List<String> SUITE_LIST = Arrays.asList("C","D","S","H");

    public static final Map<String, Integer> CARD_FACE_VALUE_MAP = Stream.of(new Object[][] {
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
}
