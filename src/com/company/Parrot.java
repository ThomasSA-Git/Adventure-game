package com.company;

public abstract class Parrot extends NPC{

  public Parrot(String name, String description, Item item){
    super(name, description, item);
  }

  public void dialogue(){

  }

  @Override
  public Item getItem() {
    return super.takeItem();
  }

}
