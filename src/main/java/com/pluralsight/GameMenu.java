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
        Player dealer = new Player("Dealer", 0);

        while (true) {
            Deck deck = new Deck();

//            Enter Bet amount
            System.out.println("Current Balance: $" + String.format("%.2f", player.getMoney()));
            System.out.println("Enter how much you want to bet: ");
            double betAmount = scanner.nextDouble();
            scanner.nextLine();

//            Deal first hand
            player.dealStartingHand(deck);
            dealer.dealStartingHand(deck);
            System.out.println(player.getName() + "currently has: " + player.getHand().getValue());

            System.out.println("""
                    []et
                    [
                    """);
        }
    }
}
