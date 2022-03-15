package com.company;

public class Room {
  private String name;
  private String description;
  private boolean lockedDoor;
  private Room north = null;
  private Room east = null;
  private Room south = null;
  private Room west = null;


  public Room(String name, String description, Room north, Room east, Room south, Room west) {

    this.name = name;
    this.description = description;
    this.lockedDoor = false;
    this.north = north;
    this.east = east;
    this.south = south;
    this.west = west;
  }

  public Room(String name, String description) {

    this.name = name;
    this.description = description;
  }

  public String toString() {
    return name;
  }

  public void setDescription(String input) {
    description = input;
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

  public void setDoorLocked() {
    if (lockedDoor) {
      lockedDoor = false;
    } else {
      lockedDoor = true;
    }
  }

  public boolean getDoorLocked(){
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
