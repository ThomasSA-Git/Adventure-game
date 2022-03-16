package com.company;

public class GameEngine {

  public void runGame() {
    Creator cr = new Creator();
    UserInterface ui = new UserInterface();
    Room room = new Room();
    cr.createRooms();
    ui.presentGame();

    boolean running = true;
    while (running) {

      ui.printCurrentRoom();


      switch (ui.getUserInput()) {
        case "go east" -> {
          if (cr.getCurrentRoom() == null) {

          } else {
            cr.setCurrentRoom(room.getEast());
          }
        }
        case "go north" -> {
          if (cr.getCurrentRoom() == null) {
            ui.blockedDirection();
          } else {
            cr.setCurrentRoom(room.getNorth());
          }
        }
        case "go west" -> {
          if (cr.getCurrentRoom() == null) {
            ui.blockedDirection();
          } else {
            cr.setCurrentRoom(room.getWest());
          }
        }
        case "go south" -> {
          if (cr.getCurrentRoom() == null) {
            ui.blockedDirection();
          } else {
            cr.setCurrentRoom(room.getSouth());
          }
        }
        case "look" -> {
          cr.getCurrentRoom().getDescription();
        }
        case "help" -> {
          ui.getHelpMenu();
        }
        case "exit" -> running = false;
      }
    }
  }
}