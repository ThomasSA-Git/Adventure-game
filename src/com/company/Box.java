package com.company;

public class Box {
  private String description;
  private Item contains;
  private boolean locked;
  private Item key;


  public Box (String description, Item contains, boolean locked, Item key){
    this.description = description;
    this.contains = contains;
    this.locked = locked;
    this.key = key;
  }

  public Box (String description, Item contains){
    this.description = description;
    this.contains = contains;
  }

  public String getDescription(){
    return description;
  }

  public boolean getLocked(){
    return locked;
  }

  public Item getContains(){
    return contains;
  }
}
