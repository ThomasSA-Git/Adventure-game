package com.company;

public class Enemy {

  private String description;
  private int health;
  private Weapon weapon;
  private boolean surpriseAttack;
  UserInterface ui = new UserInterface();

  public Enemy(String description, int health, Weapon weapon, boolean surpriseAttack) {
    this.description = description;
    this.health = health;
    this.weapon = weapon;
    this.surpriseAttack = surpriseAttack;
  }

  public boolean getSurpriseAttack(){
    return surpriseAttack;
  }

  public void surpriseAttack(){
   surpriseAttack = true;
  }

  public String getDescription() {
    return this.description;
  }

  public String toString() {
    return description;
  }

  public int getHealth() {
    return this.health;
  }

  public Weapon getWeapon() {
    return this.weapon;
  }

  public Weapon dropWeapon() {
    return weapon;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void takeDamage(int damage) {
    this.health -= damage;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public int attack() {
    ui.printString("Slap noise");
    int damage = weapon.getDamage();
    if (damage == weapon.getMaxDamage()) {
      //critical hit
      damage *= weapon.getMaxDamage();
    }
    ui.printString(description + " did " + damage + " damage to you with " + weapon);
    return damage;
  }

}
