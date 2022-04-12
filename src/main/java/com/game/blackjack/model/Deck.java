package com.game.blackjack.model;

import com.game.blackjack.Utilities;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Collections;



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

        Set<String> cardFaceValueSet = Utilities.cardFaceValueMap.keySet();

        List<String> suiteList = Utilities.suiteList;

        StringBuilder cardEntry = new StringBuilder();

        for(String suite : suiteList) {
            for(String faceValue : cardFaceValueSet) {
                cardEntry.append(suite).append(faceValue);
                cardList.add(cardEntry.toString());
                cardEntry.setLength(0);
            }
        }

        Collections.shuffle(cardList);
        System.out.println("Initialized deck of cards from program: "+cardList);
        this.deck.addAll(cardList);
    }

}
