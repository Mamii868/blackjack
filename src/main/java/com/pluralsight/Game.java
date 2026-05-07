package com.pluralsight;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;
    private double bet;

    public Game() {
    }

    public void bet(Player player, double amount) {
        boolean hasEnough = player.betMoney(amount);

        if (hasEnough) {
            System.out.println(player.getName() + " bet $" + String.format("%.2f", amount));
        } else {
            System.out.println(player.getName() + " does not have enough money!");
        }
    }

    //    Removes player's hand and adds a loss to their record
    public void bust(Player player) {
        player.setHand(null);
        player.addLoss();
        System.out.println(player.getName() + " bust!");

    }

    public void win(Player player) {
        player.setHand(null);
        player.addWin();
        System.out.println(player.getName() + " won the round!");
    }

    public void loss(Player player) {
        player.setHand(null);
        player.addLoss();
        System.out.println("The dealer won the round!");
    }

    //    addBlackjack will check if the hand is 21, so it needs to be called before the hand is removed
    public void blackjack(Player player) {
        player.addBlackjack();
        player.setHand(null);
        System.out.println(player.getName() + " got a blackjack!");
    }
}
