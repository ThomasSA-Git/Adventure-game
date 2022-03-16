package com.company;

public class GameEngine {

  public void runGame() {
    Creator.createRooms();
    UserInterface.presentGame();

    Room currentRoom;

    boolean running = true;
    while (running) {

      UserInterface.printCurrentRoom();


      switch (UserInterface.getUserInput) {
        case "go east" -> {
          if (Creator.getCurrentRoom == null) {

          } else {
            Creator.setCurrentRoom(getEast);
          }
        }
        case "go north" -> {
          if (Creator.getCurrentRoom == null) {
            UserInterface.blockedDirection();
          } else {
            Creator.setCurrentRoom(getNorth);
          }
        }
        case "go west" -> {
          if (Creator.getCurrentRoom == null) {
            UserInterface.blockedDirection();
          } else {
            Creator.setCurrentRoom(getWest);
          }
        }
        case "go south" -> {
          if (Creator.getCurrentRoom == null) {
            UserInterface.blockedDirection();
          } else {
            Creator.setCurrentRoom(getSouth);
          }
        }
        case "look" -> {
          currentRoom.getDescription();
        }
        case "help" -> {
          getHelpMenu();
        }
        case "exit" -> running = false;
      }
    }
  }
}
