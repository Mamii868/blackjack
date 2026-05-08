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

    public String getName() {
        return this.name;
    }

    public double getMoney() {
        return money;
    }

    //    Will return a boolean depending on if money was able to be bet for the game to handle
    public boolean betMoney(double amount) {
        if (this.money - amount > 0) {
            this.money -= amount;
            return true;
        }
        return false;
    }

    public Hand getHand() {
        return this.hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }


    public void dealStartingHand(Deck deck) {
//        Check if the player already has a hand
        if (this.hand != null) {
            System.out.println("Hand has already been dealt!");
            return;
        }

        this.hand = new Hand();

        // deal 5 cards from the deck and add them to the hand
        for (int i = 0; i < 2; i++) {
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

    public void addLoss() {
        this.losses += 1;
    }

    public void addWin() {
        this.wins += 1;
    }

    public void addBlackjack() {
        if (this.hand.getValue() == 21) {
            this.blackjacks += 1;
        } else {
            System.out.println("Player did not have a blackjack! score not updated.");
        }
    }
}
