package com.company;

public class Enemy {

  private String description;
  private int health;
  private Weapon weapon;
  UserInterface ui = new UserInterface();
  Room room;
  Player player;


  public Enemy(String description, int health, Weapon weapon) {
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

  public Weapon getWeapon() {
    return this.weapon;
  }

  public void dropWeapon(){
    player.getCurrentRoom().addToInventory(weapon);
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public void attack() {
    ui.printString("Slap noise");
    player.setHealth(player.getHealth() - this.weapon.getDamage());
    ui.printString(this.description + " did " + this.weapon.getDamage() + " damage to you.");
  }

  public void dyingEnemy() {

  }


}
