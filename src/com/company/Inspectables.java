package com.company;

public class Inspectables {
  private String description;
  private String inspectMessage;

  public Inspectables(String description){
    this.description = description;
  }
  public Inspectables(String description, String inspectMessage){
    this.description = description;
    this.inspectMessage = inspectMessage;
  }

  public String getInspectMessage(){
    return inspectMessage;
  }

  public String getDescription(){
    return description;
  }
}
