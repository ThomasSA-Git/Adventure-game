package com.company;

public class NPC {
  private String NpcName;
  private String NpcDescription;
  private Item item;

  public NPC(String name, String description, Item item){
    this.NpcName = name;
    this.NpcDescription = description;
    this.item = item;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public Item takeItem(){
    return item;
  }

  public void removeItem(){
    item = null;
  }

  public String getNPCdescription() {
    return NpcDescription;
  }

  public String getNpcName() {
    return NpcName;
  }

  public String dialogue(){
  return "";
  }
}
