package com.company;

public class Weapon extends Item{

  private int damage;

  public Weapon(String description, int damage) {
    super(description);
    this.damage = damage;
  }

  public String toString(){
    return getDescription();
  }

  public int getDamage() {
    return damage;
  }
}
