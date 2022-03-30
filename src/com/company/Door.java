package com.company;

public class Door {
  UserInterface ui = new UserInterface();
  private String description;
  private boolean locked;
  private final String key;
  private String unlockMessage;
  private Room leadsTo;

  Door (String description, boolean locked, String key, Room leadsTo, String unlockMessage){
    this.leadsTo = leadsTo;
    this.description = description;
    this.locked = locked;
    this.key = key;
    this.unlockMessage = unlockMessage;
  }

  Door(String description, boolean locked, String key, Room leadsTo){
    this.leadsTo = leadsTo;
    this.description = description;
    this.locked = locked;
    this.key = key;
  }

  public String getDescription(){
    return description;
  }

  public Room getLeadsTo(){
    return leadsTo;
  }

  public void unlockDoor(){
    ui.printString(unlockMessage);
    setLocked(false);
  }


  public boolean getLocked(){
    return locked;
  }

  public void setLocked(boolean locked){
    this.locked = locked;
  }

  public String getKey(){
    return key;
  }
}
