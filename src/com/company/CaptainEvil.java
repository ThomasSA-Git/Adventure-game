package com.company;

public class CaptainEvil extends Enemy{

  public CaptainEvil(String description, int health, Weapon weapon, boolean surpriseAttack){
    super(description, health, weapon, surpriseAttack);
  }

  public String attackMessage(){
    String action = "Throws chilibowl at bars and attacks you.";
    return action;
  }
}
