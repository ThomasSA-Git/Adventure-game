package com.company;

import java.util.ArrayList;

public class Creator {

  Room firstRoom;
  Player player;

  public void createRooms() {

    Interactables interactables1 = new Interactables("Door", "You can't open this.", new ArrayList<Item>());
    Weapon testWeapon = new MeleeWeapon("club", 2, 4);
    Enemy testEnemy = new Enemy("troll", 20, testWeapon);
    Room room1 = new Room("Cabin", "You find yourself in what looks like a cabin on a larger ship. The room has one door\n" +
        "You feel the shift of gravity going from one end of the room to the other in a rhythmic motion\n" +
        "Next to one of the bunk beds you see a large wooden crate\n" +
        "The room contains:\n", new ArrayList<Item>(), new ArrayList<Door>(), interactables1, testEnemy);



    Room room2 = new Room("Galley", "", new ArrayList<Item>(), new ArrayList<Door>(), interactables1, null);
    Room room3 = new Room("Ship Hold", "", new ArrayList<Item>(), new ArrayList<Door>(), interactables1, null);
    Room room4 = new Room("Brig", "", new ArrayList<Item>(), new ArrayList<Door>(), interactables1, null);
    Room room5 = new Room("Deck (Stern)", "", new ArrayList<Item>(), new ArrayList<Door>(), interactables1, null);
    Room room6 = new Room("Deck (Bow)", "", new ArrayList<Item>(), new ArrayList<Door>(), interactables1, null);
    Room room7 = new Room("Mast", "", new ArrayList<Item>(), new ArrayList<Door>(), interactables1, null);
    Room room8 = new Room("Bridge Deck", "", new ArrayList<Item>(), new ArrayList<Door>(), interactables1, null);
    Room room9 = new Room("Captains Quarters", "", new ArrayList<Item>(), new ArrayList<Door>(), interactables1, null);

    firstRoom = room1;

    //ROOM 1 (Cabin)
    //CONNECTIONS
    room1.setEast(room2);

    //DOOR
    room1.addToDoors(new Door("Heavy Door", true, "Shiny Key", room2, "You hear a clicking noise. The door is unlocked"));

    //INVENTORY
    room1.addToInventory(new Item("Shiny Key"));
    room1.addToInventory(new Food("banana", 20));
    room1.addToInventory(new MeleeWeapon("Frying Pan", 3, 5));
    room1.addToInventory(new RangedWeapon("Bow", 5, 7, 2));
    System.out.println(room1.getMapInventory());

    //ROOM 2 (Galley)
    room2.setEast(room3);
    room2.setWest(room1);

    //ROOM 3 (Ship Hold)
    room3.setWest(room2);
    room3.setEast(room4);
    room3.setNorth(room5);

    //ROOM 4 (Brig)
    room4.setWest(room3);

    //ROOM 5 (Stern)
    room5.setSouth(room3);
    room5.setEast(room6);
    room5.setWest(room8);
    room5.setDoorLocked();

    //ROOM 6 (Bow)
    room6.setWest(room5);
    room6.setNorth(room7);

    //ROOM 7 (Mast)
    room7.setSouth(room6);

    //ROOM 8 (Bridge Deck)
    room8.setEast(room5);
    room9.setSouth(room9);

    //ROOM 9 (Captains Quarters)
    room9.setNorth(room8);
  }
}
