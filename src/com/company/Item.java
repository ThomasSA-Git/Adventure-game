package com.company;

public class Item {

  private String description;

  public Item(String description){
    this.description = description;
  }

  public String getDescription(){
    return description;
  }

  public String toString(){
    return description;
  }
}
