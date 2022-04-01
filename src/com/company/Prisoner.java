package com.company;

public class Prisoner extends NPC {

  public Prisoner(String name, String description, Item item) {
    super(name, description, item);
  }

  public String dialogue() {
    String prisonerQuest = "Prisoner: Ahoy thar matey! Get a bowl o' chili fer a poor starvin' ole pirate 'n I'll share me secret booty wit' ye.";
    String bars = "A shabby set of bars are between you and the prisoner.";
    return prisonerQuest + "\n" + bars;
  }

  public String NpcRecieve(Item receive, Room currentRoom) {
    if (receive.getDescription().equalsIgnoreCase("spicy soup")) {
      turnHostile(currentRoom);
      String action = "The prisoner throws the bowl of soup at the prison bars and they quickly dissolve into nothing. He throws his biscuits defiantly at you.";
      String attackMessage = "Prisoner: You fool, I don't even like chili!";
      return action + "\n" + attackMessage;
    } else {
      String message = "Prisoner: I don't want that.";
      return message;
    }
  }

  public void turnHostile(Room currentRoom) {
    currentRoom.setNpc(null);
    currentRoom.setEnemy(new PrisonEnemy("Chili crazed prisoner", 20, new MeleeWeapon("Spoon", 5, 8), true));
    currentRoom.addToInventory(new Food("Biscuits", 1));
  }

}
