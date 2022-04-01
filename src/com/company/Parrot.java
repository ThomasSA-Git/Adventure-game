package com.company;

public class Parrot extends NPC {

  public Parrot(String name, String description, Item item) {
    super(name, description, item);
  }

  public String dialogue(Room currentRoom) {
    String parrotQuest = "Shark Bait: Don't go blabbing about the secret password Shark Bait*squack*,\ndon't go blabbing about the secret password *squack*\n" +
        "I support russia *squack*";
    String crumbs = "Biscuit crumbs are scattered all over the floor of the crow's nest";
    return parrotQuest + "\n" + crumbs;
  }

  @Override
  public Item getItem() {
    return super.takeItem();
  }

  public String NpcRecieve(Item receive, Room currentRoom) {
    if (receive.getDescription().equalsIgnoreCase("Biscuits")) {
      String action = "The parrot gobles up all the biscuits";
      String givePassword = "Shark Bait the parrot: 1234";
      return givePassword;
    } else {
      String message = "The parrot ignores you.";
      return message;
    }
  }

}
