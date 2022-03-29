package com.company;

public class NPC {
  private String NPCname;
  private String NPCdescription;
  private Item item;

  public NPC(String name, String description, Item item){
    this.NPCname = name;
    this.NPCdescription = description;
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
    return NPCdescription;
  }

  public String getNPCname() {
    return NPCname;
  }

  public void dialogue(){

  }
}
