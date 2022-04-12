package com.game.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String playerName;

    private List<String> playerHand = new ArrayList<String>();

    private int currentHandValue;

    private boolean isWinner;

    private boolean isLoser;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<String> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(List<String> playerHand) {
        this.playerHand = playerHand;
    }

    public int getCurrentHandValue() {
        return currentHandValue;
    }

    public void setCurrentHandValue(int currentHandValue) {
        this.currentHandValue = currentHandValue;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public boolean isLoser() { return isLoser; }

    public void setLoser(boolean loser) { isLoser = loser; }

    @Override
    public String toString() {
        return getPlayerName()+": "+getPlayerHand().toString();
    }
}
