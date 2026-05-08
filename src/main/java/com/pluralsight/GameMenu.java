package com.pluralsight;

import java.util.Scanner;

public class GameMenu {

    public static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.print("Enter the amount you would like to gamble with: $");
        double playerMoney = scanner.nextDouble();

        Player player = new Player(playerName, playerMoney);

        while (true) {
            Deck deck = new Deck();

            player.dealStartingHand(deck);
            System.out.println("You currently have: " + player.getHand().getValue());
            break;
        }
    }
}
