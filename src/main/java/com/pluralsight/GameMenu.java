package com.pluralsight;

import java.util.Locale;
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

            double betAmount = 0;
            while (true) {
                //            Enter Bet amount
                System.out.println("Current Balance: $" + String.format("%.2f", player.getMoney()));
                System.out.print("Enter how much you want to bet: ");
                betAmount = scanner.nextDouble();
                scanner.nextLine();

                boolean didBet = game.bet(player, betAmount);

                if (didBet) {
                    break;
                }
                Thread.sleep(1000);
            }

            Thread.sleep(1000);
//            Deal first hand
            player.dealStartingHand(deck);
            dealer.dealStartingHand(deck);

            boolean isPlaying = true;

//            Set the menu options outside to change them
            String menuOptions = """
                    [H]it
                    [D]ouble
                    [S]tand
                    """;

            while (isPlaying) {

                System.out.println(dealer.getName() + " currently has: " + dealer.getHand().getValue());
                System.out.println();
                System.out.println(player.getName() + " currently has: " + player.getHand().getValue());


                System.out.println(menuOptions);

                System.out.print("Enter option: ");
                String option = scanner.nextLine();

                drawCard(deck, player, dealer, option, betAmount);

                if (player.getHand().getValue() >= 21) {
                    isPlaying = false;
                }

                switch (option.toLowerCase()) {
                    case "h" -> {
                        menuOptions = """
                                [H]it
                                [S]tand
                                """;
                    }
                    case "d", "s" -> isPlaying = false;
                }
            }

            if (player.getHand().getValue() > 21) {
                System.out.println("Blackjack! You Win $" + betAmount * 1.5);
                player.addBlackjack();
                player.addMoney(betAmount * 1.5);
            }

        }
    }

    public static void drawCard(Deck deck, Player player, Player dealer, String option, double betAmount) {
        switch (option.toLowerCase()) {
            case "h" -> {
                System.out.println("Hitting...");
                player.hit(deck);
            }
            case "d" -> {
                if (player.getMoney() > betAmount) {
                    System.out.println("Doubling...");
                    player.betMoney(betAmount);
                    player.hit(deck);
                    dealer.hit(deck);
                }
            }
            case "s" -> System.out.println("Standing...");
        }
    }
}
