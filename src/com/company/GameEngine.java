package com.company;

import com.company.rooms.cabin.Cabin;
import com.company.ui.MainMenu;
import com.company.ui.UserInterface;


public class GameEngine {
    boolean running = true;
    Creator creator = new Creator();
    UserInterface ui = new UserInterface();
    MainMenu mainMenu = new MainMenu();
    Cabin cabin = new Cabin();

    boolean compassHasNotHappened = true;
    private com.company.gags.CompassGag CompassGag;


    public void setRunning(boolean input) {
        running = input;
    }

    public void runGame() {
        creator.createRooms();
        ui.presentGame();

        while (running) {
            switch (creator.getCurrentRoom().getName()) {
                case "Cabin" -> {
                    cabin.cabinCommands();
                    break;
                }
                case "room2" -> System.out.println("room2 works");
            }
        }
    }
}
