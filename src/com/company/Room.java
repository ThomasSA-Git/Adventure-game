package com.company;

import java.util.ArrayList;

import com.company.Item;

public class Room {
  private String name;
  private String description;
  private boolean lockedDoor;
  private Enemy enemy;
  private Room north = null;
  private Room east = null;
  private Room south = null;
  private Room west = null;
  private ArrayList<Item> mapInventory = new ArrayList<>();
  private Interactables interactable;

  public Room(String name, String description, Room north, Room east, Room south, Room west) {
    this.name = name;
    this.description = description;
    this.lockedDoor = false;
    this.north = north;
    this.east = east;
    this.south = south;
    this.west = west;


  }

  public ArrayList<Item> getMapInventory() {
    return this.mapInventory;
  }

  public Room(String name, String description, ArrayList<Item> mapInventory, Interactables interactable, Enemy enemy) {
    this.name = name;
    this.description = description + "" + interactable.getDescription();
    this.mapInventory = mapInventory;
    this.interactable = interactable;
    this.enemy = enemy;
  }

  public void setMapInventory(ArrayList<Item> newArrayList) {
    mapInventory = newArrayList;
  }

  public void removeFromInventory(Item item) {
    mapInventory.remove(item);
  }

  public void addToInventory(Item item) {
    mapInventory.add(item);
  }

  public Room() {

    this.name = name;
    this.description = description;

  }

  public String toString() {
    return name;
  }

  public void setDescription(String input) {
    this.description = input;
  }

  public void setEast(Room east) {
    this.east = east;
  }

  public void setNorth(Room north) {
    this.north = north;
  }

  public void setSouth(Room south) {
    this.south = south;
  }

  public void setWest(Room west) {
    this.west = west;
  }

  public void setName(String input) {
    name = input;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public Interactables getInteractable() {
    return this.interactable;
  }

  public void setDoorLocked() {
    if (lockedDoor) {
      lockedDoor = false;
    } else {
      lockedDoor = true;
    }
  }

  public Enemy getEnemy() {
    return this.enemy;
  }

  public boolean getDoorLocked() {
    return this.lockedDoor;
  }

  public Room getNorth() {
    return this.north;
  }

  public Room getSouth() {
    return this.south;
  }

  public Room getWest() {
    return this.west;
  }

  public Room getEast() {
    return this.east;
  }
}
