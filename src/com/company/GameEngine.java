package com.company;

public class GameEngine {

  public void runGame() {
    Creator creator = new Creator();
    UserInterface ui = new UserInterface();
    creator.createRooms();
    ui.presentGame();

    boolean running = true;
    while (running) {

      ui.printCurrentRoom();

      switch (ui.getUserInput()) {
        case "go east" -> {
          if (creator.getCurrentRoom() == null) {

          } else {
            creator.setCurrentRoom(creator.getCurrentRoom().getEast());
          }
        }
        case "go north" -> {
          if (creator.getCurrentRoom() == null) {
            ui.blockedDirection();
          } else {
            creator.setCurrentRoom(creator.getCurrentRoom().getNorth());
          }
        }
        case "go west" -> {
          if (creator.getCurrentRoom() == null) {
            ui.blockedDirection();
          } else {
            creator.setCurrentRoom(creator.getCurrentRoom().getWest());
          }
        }
        case "go south" -> {
          if (creator.getCurrentRoom() == null) {
            ui.blockedDirection();
          } else {
            creator.setCurrentRoom(creator.getCurrentRoom().getSouth());
          }
        }
        case "look" -> {
          creator.getCurrentRoom().getDescription();
        }
        case "help" -> {
          ui.getHelpMenu();
        }
        case "exit" -> running = false;
      }
    }
  }
}