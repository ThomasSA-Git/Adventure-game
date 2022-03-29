package com.company;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Weapon extends Item {

  private int minDamage;
  private int maxDamage;

  public Weapon(String description, int minDamage, int maxDamage) {
    super(description);
    this.minDamage = minDamage;
    this.maxDamage = maxDamage;
  }

  public String toString() {
    return getDescription();
  }

  public int getDamage() {
    int damage = ThreadLocalRandom.current().nextInt(this.minDamage, this.maxDamage);
    return damage;
  }

  public int getMaxDamage() {
    return this.maxDamage;
  }

  public int getMinDamage() {
    return this.minDamage;
  }
}
