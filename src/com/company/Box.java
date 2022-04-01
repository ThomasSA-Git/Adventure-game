package com.company;

public class Box {
  private String description;
  private Item contains;
  private boolean locked;
  private String key;
  private String unlockMessage;


  public Box (String description, Item contains, boolean locked, String key, String unlockMessage){
    this.description = description;
    this.contains = contains;
    this.locked = locked;
    this.key = key;
    this.unlockMessage = unlockMessage;
  }

  public Box (String description, Item contains){
    this.description = description;
    this.contains = contains;
  }

  public String getKey(){
    return key;
  }


  public String toString(){
    return description;
  }

  public String getDescription(){
    return description;
  }

  public String getUnlockMessage(){
    return unlockMessage;
  }

  public boolean getLocked(){
    return locked;
  }

  public Item getContains(){
    return contains;
  }
}
