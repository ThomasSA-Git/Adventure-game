package com.company;

import java.util.ArrayList;

public class Player {
  Room currentRoom;
  ArrayList<Item> playerInventory;
  Room room = new Room();

  private int damage = 1;
  private int health = 70;
  private Weapon fists = new Weapon ("Fists", 1);
  private Weapon equippedWeapon = fists;

  public void eat(Food food){
    health = health + food.getHealthGain();
    if (health > 100){
      health = 100;
    }
  }

  public void equip(Weapon weapon){
    setEquippedWeapon(weapon);
    setDamage(equippedWeapon.getDamage());
  }

  public int getDamage(){
    return damage;
  }

  public void deEquip(){
    setEquippedWeapon(fists);
    setDamage(1);
  }

  public void setDamage(int damage) {
    this.damage = damage;
  }

  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }

  public void setEquippedWeapon(Weapon equippedWeapon) {
    this.equippedWeapon = equippedWeapon;
  }

  public int getHealth(){
    return health;
  }

  public Player(Room currentRoom) {
    this.currentRoom = currentRoom;
    playerInventory = new ArrayList<>();
  }

  public void takeItem(Room currentRoom, Item item) {
    playerInventory.add(item);
    currentRoom.removeFromInventory(item);
    System.out.println(playerInventory);
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
}
