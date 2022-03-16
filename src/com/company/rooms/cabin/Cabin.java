package com.company.rooms.cabin;

import com.company.Creator;
import com.company.GameEngine;
import com.company.ui.UserInterface;
import com.company.gags.CompassGag;

public class Cabin {
    UserInterface ui = new UserInterface();

    boolean compassHasNotHappened = true;
    private CompassGag CompassGag;
    private Creator creator = new Creator();

    public void checkCompassGag() {
        CompassGag = new CompassGag();
        if (compassHasNotHappened) {
            try {
                CompassGag.compassGag();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            compassHasNotHappened = false;
        }
    }

    public void cabinCommands() {

        boolean invalidInput = true;
        boolean inCabin = true;
        creator.createRooms();

        while (inCabin) {
            while (invalidInput) {
                switch (ui.getUserInput()) {
                    case "go east" -> {
                        checkCompassGag();
                        if (creator.getCurrentRoom().getEast() == null) {
                            ui.blockedDirection();
                        } else {
                            creator.setCurrentRoom(creator.getCurrentRoom().getEast());
                            invalidInput = false;
                            inCabin = false;
                        }
                    }
                    case "go north" -> {
                        checkCompassGag();
                        if (creator.getCurrentRoom().getNorth() == null) {
                            ui.blockedDirection();
                        } else {
                            creator.setCurrentRoom(creator.getCurrentRoom().getNorth());
                            inCabin = false;
                        }
                        invalidInput = false;
                    }
                    case "go west" -> {
                        checkCompassGag();
                        if (creator.getCurrentRoom().getWest() == null) {
                            ui.blockedDirection();
                        } else {
                            creator.setCurrentRoom(creator.getCurrentRoom().getWest());
                            inCabin = false;
                        }
                        invalidInput = false;
                    }
                    case "go south" -> {
                        checkCompassGag();
                        if (creator.getCurrentRoom().getSouth() == null) {
                            ui.blockedDirection();
                        } else {
                            creator.setCurrentRoom(creator.getCurrentRoom().getSouth());
                            inCabin = false;
                        }
                        invalidInput = false;
                    }
                    case "look" -> {
                        System.out.println(creator.getCurrentRoom().getDescription());
                        invalidInput = false;
                    }

                    case "exit" -> {
                        new GameEngine().setRunning(false);
                    }
                    default -> System.out.println("Invalid input");
                }
            }
        }
    }
}