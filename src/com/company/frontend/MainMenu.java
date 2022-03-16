package com.company.frontend;

import com.company.backend.GameEngine;

import java.util.Scanner;

public class MainMenu {
    public void displayMenu() {
        boolean menuRunning = true;
        Scanner sc = new Scanner(System.in);
        UserInterface ui = new UserInterface();

        while (menuRunning) {
            System.out.println("""
                --------MAIN MENU--------
                1. Start Game 
                2. Credits
                3. Exit Game
                """);
            switch (ui.getUserInput()) {
                case "1" -> {
                    new GameEngine().runGame();
                    menuRunning = false;
                }
                case "2" -> {
                    System.out.println(new Credits().getCredits());
                    System.out.println("Press enter to exit credits");
                    sc.nextLine();
                }
                case "3" -> {
                    System.out.println("Exiting game...");
                    menuRunning = false;
                }
                default -> System.out.println("Invalid input");
            }
        }
    }
}
