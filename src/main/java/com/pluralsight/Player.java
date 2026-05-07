package com.pluralsight;

public class Player {
    private final String name;
    private Hand hand;
    private double money;
    private int wins;
    private int losses;
    private int blackjacks;

    public Player(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public Hand getHand() {
        return this.hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }


    public void dealStartingHand(Deck deck) {
//        Check if the player already has a hand
        if (this.hand.getSize() > 0) {
            System.out.println("Hand has already been dealt!");
            return;
        }

        // deal 5 cards from the deck and add them to the hand
        for (int i = 0; i < 5; i++) {
            // get a card from the deck
            Card card = deck.deal();
            // deal that card to the hand
            this.hand.deal(card);
        }
    }

    //    Adds another card to the player's hand and returns the value of the entire hand
    public int hit(Deck deck) {
        Card card = deck.deal();
        this.hand.deal(card);

        return this.hand.getValue();
    }

    public void doubleHit() {

    }
}
