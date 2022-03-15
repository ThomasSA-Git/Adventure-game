package com.company;

import java.util.Scanner;

public class Adventure {
  //DECLARE VARIABLES
  Scanner sc = new Scanner(System.in);

  Room room1 = new Room("Room: 1", "");
  Room room2 = new Room("Room: 2", "");
  Room room3 = new Room("Room: 3", "");
  Room room4 = new Room("Room: 4", "");
  Room room5 = new Room("Room: 5", "");
  Room room6 = new Room("Room: 6", "");
  Room room7 = new Room("Room: 7", "");
  Room room8 = new Room("Room: 8", "");
  Room room9 = new Room("Room: 9", "");

  Room currentRoom = room1;

  public void createRooms() {
    //ROOM 1
    room1.setEast(room2);
    room1.setSouth(room4);

    //ROOM 2
    room2.setEast(room3);
    room2.setWest(room1);

    //ROOM 3
    room3.setWest(room2);
    room3.setSouth(room6);

    //ROOM 4
    room4.setNorth(room1);
    room4.setSouth(room7);

    //ROOM 5
    room5.setSouth(room8);

    //ROOM 6
    room6.setNorth(room3);
    room6.setSouth(room9);

    //ROOM 7
    room7.setNorth(room4);
    room7.setEast(room8);

    //ROOM 8
    room8.setNorth(room5);
    room8.setWest(room7);
    room8.setEast(room9);

    //ROOM 9
    room9.setNorth(room6);
    room9.setWest(room8);
  }

  public void execute() {
    createRooms();
    presentGame();

    boolean running = true;
    while (running) {

      System.out.print("You are currently in: ");
      System.out.println(currentRoom);

      String userIn = sc.nextLine();


      switch (userIn) {
        case "go east" -> {

          if (currentRoom.getEast() == null) {
            System.out.println("You can't go this way");
          } else {
            currentRoom = currentRoom.getEast();
          }
        }
        case "go north" -> {

          if (currentRoom.getNorth() == null) {
            System.out.println("You can't go this way");
          } else {
            currentRoom = currentRoom.getNorth();
          }
        }
        case "go west" -> {
          if (currentRoom.getWest() == null) {
            System.out.println("You can't go this way");
          } else {
            currentRoom = currentRoom.getWest();
          }
        }
        case "go south" -> {
          if (currentRoom.getSouth() == null) {
            System.out.println("You can't go this way");
          } else {
            currentRoom = currentRoom.getSouth();
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

  public void presentGame() {
    System.out.println("""
        WELCOME TO <placeholder>
        You can always write 'help' to see a list of commands
        """);
  }

  public void getHelpMenu() {
    System.out.println("""
        ---------HELP MENU---------
        go <direction>: Moves your character to the next room in chosen location
        look: Look around (You might find something interesting)
        help: Display this menu
        exit: Close game
        """);
  }


  public String getParameter(String input) {
    int firstSpace = input.indexOf(" ");
    return input.substring(firstSpace + 1);
  }


  public static void main(String[] args) {
    new Adventure().execute();
  }
}
