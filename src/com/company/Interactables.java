package com.company;

import java.util.ArrayList;

public class Interactables {

  private String description;
  private String message;
  private ArrayList<Item> interList = new ArrayList<>();

  public Interactables(String description, String message, ArrayList<Item> interList) {
    this.description = description;
    this.message = message;
    this.interList = interList;
  }

  public String toString() {
    return description + "\n" + message;
  }

  public String getDescription() {
    return description;
  }

  public String getMessage() {
    return message;
  }

  public ArrayList<Item> getInterList() {
    return interList;
  }
  public void removeFromInventory(Item item) {
    interList.remove(item);
  }

  public void addToInventory(Item item) {
    interList.add(item);
  }
}
