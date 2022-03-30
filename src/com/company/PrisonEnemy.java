package com.company;

public class PrisonEnemy extends Enemy{

  public PrisonEnemy(String description, int health, Weapon weapon){
    super(description, health, weapon);

  }

  public String attackMessage(){
    String action = "Throws chilibowl at bars and attacks you.";
    String message = "";
    return action + "\n" + message;
  }
}
