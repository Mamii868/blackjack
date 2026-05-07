package com.pluralsight;

public class Player {
    private final String name;
    private Hand hand;
    private int wins;
    private int losses;
    private int blackjacks;

    public Player(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return this.hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
}
