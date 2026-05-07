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
}
