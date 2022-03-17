package com.company;

public class GameEngine {

  public void runGame() {
    Player player = new Player();
    Creator cr = new Creator();
    UserInterface ui = new UserInterface();
    Room room = new Room();
    cr.createRooms();
    ui.presentGame();

    boolean running = true;
    while (running) {

      ui.printCurrentRoom(cr.getCurrentRoom());

      String userInput = ui.getUserInput();
      switch (userInput) {
        case "go east" -> {
          if (cr.getCurrentRoom().getEast() == null) {
            ui.blockedDirection();
          } else {
            cr.setCurrentRoom(cr.getCurrentRoom().getEast());
          }
        }
        case "go north" -> {
          if (cr.getCurrentRoom().getNorth() == null) {;
            ui.blockedDirection();
          } else {
            cr.setCurrentRoom(cr.getCurrentRoom().getNorth());
          }
        }
        case "go west" -> {
          if (cr.getCurrentRoom().getWest() == null) {
            ui.blockedDirection();
          } else {
            cr.setCurrentRoom(cr.getCurrentRoom().getWest());
          }
        }
        case "go south" -> {
          if (cr.getCurrentRoom().getSouth() == null) {
            ui.blockedDirection();
          } else {
            cr.setCurrentRoom(cr.getCurrentRoom().getSouth());
          }
        }


        case "take" -> {
          System.out.println("What do you want to take?");
          String take = ui.getUserInput();
          for (int i = 0; i < cr.getCurrentRoom().getMapInventory().size(); i++){
            if (cr.getCurrentRoom().getMapInventory().get(i).getDescription().equals(take)){
              player.takeItem(cr.getCurrentRoom(), cr.getCurrentRoom().getMapInventory().get(i));
            } else {
              System.out.println("This item does not exist");
            }
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

    public boolean checkTake (String input){
    return getPrefix(input).equals("take");
    }

    public int getSpace(String input){
    return input.indexOf(" ");
    }

    public String getPrefix(String input){
    return input.substring(0, getSpace(input));
    }

    public String getUserSuffix(String input){
      int space = getSpace(input);
      return input.substring(space + 1);
    }
}
