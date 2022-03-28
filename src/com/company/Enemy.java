package com.company;

public class Enemy {

  private String description;
  private int health;
  private Weapon weapon;
  UserInterface ui = new UserInterface();
  Room room;
  Player player = new Player(room);


  public Enemy(String description, int health, Weapon weapon) {
    this.description = description;
    this.health = health;
    this.weapon = weapon;
  }

  public String getDescription() {
    return this.description;
  }

  public String toString(){
    return description;
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

  public void takeDamage(int damage){
    this.health -= damage;
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public void attack() {
    ui.printString("Slap noise");
    int damage = this.weapon.getDamage();
    if(damage == this.weapon.getMaxDamage()){
      //critical hit
      damage *= this.weapon.getMaxDamage();
    }
    player.takeDamage(damage);
    ui.printString(this.description + " did " + damage + " damage to you.");
  }

  public void dyingEnemy() {

  }


}
