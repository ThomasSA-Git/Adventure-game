package com.company;

public class CodeDoor extends Door{

  private String code;

  public CodeDoor(String description, boolean locked, String key, Room leadsTo, String code, String unlockMessage){
    super(description, locked, key, leadsTo, unlockMessage);
    this.code = code;
  }

  public String getCode(){
    return code;
  }
}
