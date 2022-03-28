package com.company;

import java.util.ArrayList;

public class Creator {

  Room firstRoom;
  Player player;

  public void createRooms() {

    Interactables interactables1 = new Interactables("Door", "You can't open this.", new ArrayList<Item>());
    Weapon testWeapon = new Weapon("club", 2, 4);
    Enemy testEnemy = new Enemy("troll", 20, testWeapon);
    Room room1 = new Room("Room: 1", "The room contains:\n", new ArrayList<Item>(), interactables1, testEnemy);
    room1.addToInventory(new Item("key"));
    room1.addToInventory(new Food("banana", 20));
    room1.addToInventory(new Weapon("Frying Pan", 3, 5
    ));
    System.out.println(room1.getMapInventory());



    Room room2 = new Room("Room: 2", "", new ArrayList<Item>(), interactables1, null);
    Room room3 = new Room("Room: 3", "", new ArrayList<Item>(), interactables1, null);
    Room room4 = new Room("Room: 4", "", new ArrayList<Item>(), interactables1, null);
    Room room5 = new Room("Room: 5", "", new ArrayList<Item>(), interactables1, null);
    Room room6 = new Room("Room: 6", "", new ArrayList<Item>(), interactables1, null);
    Room room7 = new Room("Room: 7", "", new ArrayList<Item>(), interactables1, null);
    Room room8 = new Room("Room: 8", "", new ArrayList<Item>(), interactables1, null);
    Room room9 = new Room("Room: 9", "", new ArrayList<Item>(), interactables1, null);

    firstRoom = room1;

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
    room5.setDoorLocked();

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
}