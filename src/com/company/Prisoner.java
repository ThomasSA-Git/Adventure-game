package com.company;

public class Prisoner extends NPC{

  public Prisoner(String name, String description, Item item){
    super(name, description, item);
  }

  public String dialogue(){
  String prisonerQuest = "Prisoner: Ahoy thar matey! Get a bowl o' chili fer a poor starvin' ole pirate 'n I'll share me secret booty wit' ye.";
  String bars = "A shabby set of bars are between you and the prisoner.";
    return prisonerQuest + "\n" + bars;
  }

  public void NpcRecieve(Item receive){
    if(receive.getDescription().equalsIgnoreCase("bowl of chili")) {
      turnHostile();

    }
    else {

    }
  }

  public void turnHostile(){

  }

}
