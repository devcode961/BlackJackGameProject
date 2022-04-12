package com.game.blackjack.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Deck {

    public ArrayDeque<String> getDeck() {
        return deck;
    }

    private ArrayDeque<String> deck = new ArrayDeque<>();


    private final List<String> suiteList = Arrays.asList("C","D","S","H");

    private final Map<String, Integer> cardFaceValueMap = Stream.of(new Object[][] {
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

    public  void initializeShuffledCardDeck() {

        List<String> cardList = new ArrayList<>();

        Set<String> cardFaceValueSet = cardFaceValueMap.keySet();

        StringBuilder cardEntry = new StringBuilder();

        for(String suite : suiteList) {
            for(String faceValue : cardFaceValueSet) {
                cardEntry.append(suite).append(faceValue);
                cardList.add(cardEntry.toString());
                cardEntry.setLength(0);
            }
        }

        Collections.shuffle(cardList);

        System.out.println("Initialized deck of cards : "+cardList);

        //Collections.reverse(cardList);

        this.deck.addAll(cardList);
    }



}
