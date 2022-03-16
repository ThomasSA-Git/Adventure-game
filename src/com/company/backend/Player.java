package com.company.backend;

public class Player {
    int health;
    String[] inventory;

    public Player(){
        this.health = 100;
        this.inventory = new String[10];
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public String[] getInventory(){
        return inventory;
    }
}
