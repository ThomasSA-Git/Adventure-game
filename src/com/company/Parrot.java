package com.company;

public class Parrot extends NPC{

  public Parrot(String name, String description, Item item){
    super(name, description, item);
  }

  public String dialogue(){
    String parrotQuest = "Shark Bait: Don't go blabbing about the secret password Shark Bait*squack*,\ndon't go blabbing about the secret password";
    String crumbs = "Biscuit crumbs are scattered all over the floor of the crow's nest";
    return parrotQuest + "\n" + crumbs;
  }

  @Override
  public Item getItem() {
    return super.takeItem();
  }

  public String NpcRecieve(Item receive, Room currentRoom){
    if(receive.getDescription().equalsIgnoreCase("Biscuits"));
    return "";
  }

}
