package com.company;

public class CaptainNPC extends NPC{

  public CaptainNPC(String name, String description, Item item) {
    super(name, description, item);
  }

  public String dialogue() {
    String prisonerQuest = "Captain: What ar' ya doin' in me capn' quarters? Did he send ye? Yer' not getting me bottle!";
    String narrator = "Narrator: THERE IT IS! GET THAT POTION";
    String potion = "The captain has a firm grip around a bottle of Jack Daniels";
    return prisonerQuest + "\n" + narrator + "\n" + potion;
  }

  public void turnHostile(Room currentRoom) {
    currentRoom.setNpc(null);
    currentRoom.setEnemy(new CaptainEvil("Captain evil", 40, new MeleeWeapon("Scimitar", 6, 9), true));
    currentRoom.getEnemy().attack();
    currentRoom.getEnemy().surpriseAttack();
    currentRoom.addToInventory(new Item ("jack daniels"));
  }

}
