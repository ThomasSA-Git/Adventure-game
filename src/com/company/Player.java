package com.company;

import java.security.PublicKey;
import java.util.ArrayList;

public class Player {
  Room currentRoom;
  ArrayList<Item> playerInventory;
  Room room = new Room();
  UserInterface ui = new UserInterface();

  private int health = 70;
  private Weapon fists = new MeleeWeapon("Fists", 1, 2);
  private Weapon equippedWeapon = fists;


  public void eat(Food food) {
    this.health = health + food.getHealthGain();
    if (health > 100) {
      health = 100;
    }
  }

  public Player() {

  }

  public void equip(Weapon weapon) {
    setEquippedWeapon(weapon);
  }

  public int getDamage() {
    return this.equippedWeapon.getDamage();
  }

  public void deEquip() {
    setEquippedWeapon(fists);
  }

  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }

  public void setEquippedWeapon(Weapon equipWeapon) {
    this.equippedWeapon = equipWeapon;
  }

  public int getHealth() {
    return this.health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void takeDamage(int damage) {
    this.health -= damage;
  }

  public Player(Room currentRoom) {
    this.currentRoom = currentRoom;
    playerInventory = new ArrayList<>();
    this.health = getHealth();
  }

  public void takeItem(Room currentRoom, Item item) {
    playerInventory.add(item);
    currentRoom.removeFromInventory(item);
    System.out.println(playerInventory);
  }

  public void takeIntItem(Interactables interactables, Item item) {
    playerInventory.add(item);
    interactables.removeFromInventory(item);
  }

  public ArrayList<Item> getPlayerInventory() {
    return playerInventory;
  }

  public Room getCurrentRoom() {
    return currentRoom;
  }

  public void setCurrentRoom(Room currentRoom) {
    this.currentRoom = currentRoom;
  }

  public String toString() {
    return String.valueOf(playerInventory);
  }

  public void dropItem(Room currentRoom, Item item) {
    currentRoom.addToInventory(item);
    playerInventory.remove(item);
  }

  public void removeItem(Item item){
    playerInventory.remove(item);
  }

  public void attack() {
    ui.printString("Slap noise");
    int damage = this.equippedWeapon.getDamage();
    if (damage == this.equippedWeapon.getMaxDamage()) {
      //critical hit
      damage *= this.equippedWeapon.getMaxDamage();
    }
    currentRoom.getEnemy().takeDamage(damage);
    ui.printString("You did " + damage + " damage to " + currentRoom.getEnemy());
  }
}

