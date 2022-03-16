package com.company.backend.rooms;

import com.company.backend.RoomCreator;
import com.company.backend.GameEngine;
import com.company.frontend.UserInterface;
import com.company.frontend.gags.CompassGag;
import com.company.frontend.gags.BeeEncounterGag;

public class Cabin {
    UserInterface ui = new UserInterface();
    BeeEncounterGag bee = new BeeEncounterGag();

    boolean compassHasNotHappened = true;
    private CompassGag CompassGag;
    private RoomCreator roomCreator = new RoomCreator();

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
        roomCreator.connectRooms();

        while (inCabin) {
            while (invalidInput) {
                switch (ui.getUserInput()) {
                    case "go east" -> {
                        checkCompassGag();
                        if (roomCreator.getCurrentRoom().getEast() == null) {
                            ui.blockedDirection();
                        } else {
                            roomCreator.setCurrentRoom(roomCreator.getCurrentRoom().getEast());
                            invalidInput = false;
                            inCabin = false;
                        }
                    }
                    case "go north" -> {
                        checkCompassGag();
                        if (roomCreator.getCurrentRoom().getNorth() == null) {
                            ui.blockedDirection();
                        } else {
                            roomCreator.setCurrentRoom(roomCreator.getCurrentRoom().getNorth());
                            inCabin = false;
                        }
                        invalidInput = false;
                    }
                    case "go west" -> {
                        checkCompassGag();
                        if (roomCreator.getCurrentRoom().getWest() == null) {
                            ui.blockedDirection();
                        } else {
                            roomCreator.setCurrentRoom(roomCreator.getCurrentRoom().getWest());
                            inCabin = false;
                        }
                        invalidInput = false;
                    }
                    case "go south" -> {
                        checkCompassGag();
                        if (roomCreator.getCurrentRoom().getSouth() == null) {
                            ui.blockedDirection();
                        } else {
                            roomCreator.setCurrentRoom(roomCreator.getCurrentRoom().getSouth());
                            inCabin = false;
                        }
                        invalidInput = false;
                    }
                    case "look" -> System.out.println(roomCreator.getCurrentRoom().getDescription());

                    case "open crate" -> {
                        try {
                            bee.execute();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        invalidInput = false;
                    }

                    case "exit" -> {
                        new GameEngine().setRunning(false);
                        invalidInput = false;
                    }
                    default -> System.out.println("Invalid input");
                }
            }
        }
    }
}