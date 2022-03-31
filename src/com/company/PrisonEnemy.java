package com.company;

public class PrisonEnemy extends Enemy{

  public PrisonEnemy(String description, int health, Weapon weapon, boolean surpriseAttack){
    super(description, health, weapon, surpriseAttack);

  }

  public String attackMessage(){
    String action = "Throws chilibowl at bars and attacks you.";
    String message = "";
    return action + "\n" + message;
  }
}
