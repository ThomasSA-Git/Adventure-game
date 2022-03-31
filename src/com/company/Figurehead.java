package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Figurehead extends NPC{

  public Figurehead(String name, String description, Item item){
    super(name, description, item);
  }

  public String dialogue() {
    int gibberish = ThreadLocalRandom.current().nextInt(1, 5);
    switch (gibberish){
      case 1 -> {
        String gibberish1 = "Figurehead: I desire... macaroni paintings";
        return gibberish1;
      }
      case 2 -> {
        String gibberish2 = "Figurehead: BAH-CHAN, BAH-CHAN BA-CHUY CHUY CHAN";
        return gibberish2;
      }
      case 3 -> {
        String gibberish3 = "Figurehead: DO YOU WANT TO SEE MY COLLECTION OF TOE NAIL CLIPPINGS?!";
        return gibberish3;
      }
      case 4 -> {
        String gibberish4 = "Figurehead: DON'T TRUST THE PARROT, HE STOLE MY PENNIES!";
        return gibberish4;
      }
    }
    return "";
  }
}
