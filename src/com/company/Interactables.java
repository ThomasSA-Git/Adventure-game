package com.company;

import java.util.ArrayList;

public class Interactables {

  private String description;
  private String message;

  public Interactables(String description, String message, ArrayList<Item> interList) {
    this.description = description;
    this.message = message;
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
}
