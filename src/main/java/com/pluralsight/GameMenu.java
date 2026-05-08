package com.pluralsight;

import java.util.Scanner;

public class GameMenu {

    public static Scanner scanner = new Scanner(System.in);

    public static void displayMenu() throws InterruptedException {

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.print("Enter the amount you would like to gamble with: $");
        double playerMoney = scanner.nextDouble();

        Player player = new Player(playerName, playerMoney);
        Player dealer = new Player("Dealer", 0);

        while (true) {
            Game game = new Game();
            Deck deck = new Deck();

            while (true) {
                //            Enter Bet amount
                System.out.println("Current Balance: $" + String.format("%.2f", player.getMoney()));
                System.out.print("Enter how much you want to bet: ");
                double betAmount = scanner.nextDouble();
                scanner.nextLine();

                boolean didBet = game.bet(player, betAmount);

                if (didBet) {
                    break;
                }
                Thread.sleep(1000);
            }


//            Deal first hand
            player.dealStartingHand(deck);
            dealer.dealStartingHand(deck);
            System.out.println(player.getName() + " currently has: " + player.getHand().getValue());

            System.out.println("""
                    [B]et
                    [D]ouble
                    [S]tand
                    """);
        }
    }
}
