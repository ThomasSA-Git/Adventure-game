package com.company;

public class RangedWeapon extends Weapon {

    private int ammo;

    public RangedWeapon(String description, int minDamage, int maxDamage, int ammo) {
        super(description, minDamage, maxDamage);
        this.ammo = ammo;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo){
        this.ammo = ammo;
    }
}
