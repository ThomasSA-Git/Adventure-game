package com.company;

import java.util.ArrayList;


public class Player {
  Room currentRoom;
  ArrayList<Item> playerInventory;
  Room room = new Room();
  Creator creator = new Creator();

  public Player(Room currentRoom) {
    this.currentRoom = currentRoom;
    playerInventory = new ArrayList<>();
  }

  public void takeItem(Room currentRoom, Item item) {
    playerInventory.add(item);
    currentRoom.removeFromInventory(item);
    System.out.println(playerInventory);
  }

  public ArrayList<Item> getPlayerInventory() {
    return playerInventory;
  }

  public Room getCurrentRoom() {
    return currentRoom;
  }

  public void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  public String toString() {
    return String.valueOf(playerInventory);
  }

  public void dropItem(Room currentRoom, Item item) {
  currentRoom.addToInventory(item);
  playerInventory.remove(item);
  }
}
