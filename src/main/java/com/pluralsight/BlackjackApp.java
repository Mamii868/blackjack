package com.pluralsight;

import static com.pluralsight.GameMenu.displayMenu;

public class BlackjackApp {

    public static void main(String[] args) {
        try {
            displayMenu();
        } catch (Exception e) {
            System.out.println("Something went wrong! Exiting...");
            System.exit(500);
        }
    }

}