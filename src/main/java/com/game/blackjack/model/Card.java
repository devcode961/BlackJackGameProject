package com.game.blackjack.model;

public enum Card {

    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(10, "J"),
    QUEEN(10, "Q"),
    KING(10, "K"),
    ACE(11, "A");

    private int cardValue;

    private String faceValue;


    Card(int cardValue, String faceValue) {
        this.cardValue = cardValue;
        this.faceValue = faceValue;
    }

    public int getCardValue() {
        return cardValue;
    }

    public String getFaceValue() {
        return faceValue;
    }
}
