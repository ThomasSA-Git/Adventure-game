package com.company.backend;

import com.company.backend.rooms.Cabin;
import com.company.frontend.UserInterface;


public class GameEngine {
    boolean running = true;
    RoomCreator roomCreator = new RoomCreator();
    UserInterface ui = new UserInterface();
    Cabin cabin = new Cabin();

    boolean compassHasNotHappened = true;
    private com.company.frontend.gags.CompassGag CompassGag;


    public void setRunning(boolean input) {
        running = input;
    }

    public void runGame() {
        roomCreator.connectRooms();
        ui.presentGame();

        while (running) {
            switch (roomCreator.getCurrentRoom().getName()) {
                case "Cabin" -> roomCreator.setCurrentRoom(cabin.cabinCommands());

                case "Room: 2" -> System.out.println("room2 works");
            }
        }
    }
}
