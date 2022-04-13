package com.game.blackjack.model;


import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import static com.game.blackjack.constants.GameConstants.CARD_FACE_VALUE_MAP;
import static com.game.blackjack.constants.GameConstants.SUITE_LIST;


public class Deck {

    private ArrayDeque<String> deck = new ArrayDeque<>();

    public ArrayDeque<String> getDeck() {
        return deck;
    }

    public void setDeck(ArrayDeque<String> deck) {
        this.deck = deck;
    }

    public  void initializeShuffledCardDeck() {

        List<String> cardList = new ArrayList<>();

        StringBuilder cardEntry = new StringBuilder();

        for(String suite : SUITE_LIST) {
            for(String faceValue : CARD_FACE_VALUE_MAP.keySet()) {
                cardEntry.append(suite).append(faceValue);
                cardList.add(cardEntry.toString());
                cardEntry.setLength(0);
            }
        }

        Collections.shuffle(cardList);
        System.out.println("Initialized deck of cards within program: \n CARD DECK : "+cardList);
        this.deck.addAll(cardList);
    }

}
