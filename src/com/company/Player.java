package com.company;

import java.util.ArrayList;


public class Player {
  ArrayList<Item> playerInventory;
  Room room = new Room();
  Creator creator = new Creator();

  public Player() {
    playerInventory = new ArrayList<>();
  }

  public void takeItem(Room currentRoom, Item item) {
    playerInventory.add(item);
    System.out.println(playerInventory);

  }

  public ArrayList<Item> getPlayerInventory() {
    return playerInventory;
  }

  public String toString() {
    return String.valueOf(playerInventory);
  }

  public void dropItem(Item item) {
  room.addToInventory(item);
  playerInventory.remove(item);
  }
}
