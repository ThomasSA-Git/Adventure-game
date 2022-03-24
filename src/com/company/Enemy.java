package com.company;

public class Enemy {

  private String description;
  private int health;
  private Item weapon;
  private Player player;

  public Enemy(String description, int health, Item weapon){
    this.description = description;
    this.health = health;
    this.weapon = weapon;
  }

  public String getDescription() {
    return this.description;
  }

  public int getHealth() {
    return this.health;
  }

  public Item getWeapon(){
    return this.weapon;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void setWeapon(Item weapon) {
    this.weapon = weapon;
  }

  public void attack(){
    Item.get

    player.setHealth();
  }
}
