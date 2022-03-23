package com.company;

public class Interactables {

  private String description;
  private String message;

  public Interactables(String description, String message) {
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
