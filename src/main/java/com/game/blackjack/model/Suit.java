package com.game.blackjack.model;

public enum Suit {
    HEART("H"),
    SPADE("S"),
    CLUB("C"),
    DIAMOND("D");

    private String shortHand;

    Suit(String shortHand) {
        this.shortHand = shortHand;
    }

    public String getSuiteShortHand() {
        return shortHand;
    }
}
