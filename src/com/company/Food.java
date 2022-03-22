package com.company;

public class Food extends Item{

  private int healthGain;

  public Food(String description, int healthGain) {
    super(description);
    this.healthGain = healthGain;
  }

  public int getHealthGain(){
    return healthGain;
  }
}
