package com.company;

import com.company.gags.FunnyBeeEncounter;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class GameEngine {


  Clip clip;

  public void runGame() {


    Creator creator = new Creator();
    UserInterface ui = new UserInterface();
    creator.createRooms();
    Player player = new Player(creator.firstRoom);
    //playNarratorTheme();
    ui.presentGame();

    boolean running = true;


    while (running) {

      for (int i = 0; i < player.getPlayerInventory().size(); i++){
        if (player.getPlayerInventory().get(i).getDescription().equalsIgnoreCase("jack daniels")){
          ui.printString("Narrator:");
          try {
            ui.printOneLetterAtATime("YOU DID IT. YOU GOT IT. YOU WIN KK BYE BYE", 0.05);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          running = false;
        }
      }

      ui.printCurrentRoom(player.getCurrentRoom());

      if (player.getHealth() <= 0) {
        running = false;
      }

      if (player.getCurrentRoom().getEnemy() != null) {
        if (player.getCurrentRoom().getEnemy().getSurpriseAttack()) {
          attackSequence(player, ui);
        }
      }

      String userInput = ui.getUserInput();
      switch (userInput) {
        case "go east" -> {
          if (player.getCurrentRoom().getEast() == null) {
            ui.blockedDirection();
          } else {
            player.setCurrentRoom(player.getCurrentRoom().getEast());
          }
        }
        case "go north" -> {
          if (player.getCurrentRoom().getNorth() == null) {
            ui.blockedDirection();
          } else {
            player.setCurrentRoom(player.getCurrentRoom().getNorth());
          }
        }
        case "go west" -> {
          if (player.getCurrentRoom().getWest() == null) {
            ui.blockedDirection();
          } else {
            player.setCurrentRoom(player.getCurrentRoom().getWest());
          }
        }
        case "go south" -> {
          if (player.getCurrentRoom().getSouth() == null) {
            ui.blockedDirection();
          } else {
            player.setCurrentRoom(player.getCurrentRoom().getSouth());
          }
        }
        case "stop" ->stopNarratorTheme();
        case "open" -> open(player, ui);
        case "inventory" -> ui.printArrayList(player.getPlayerInventory());
        case "take" -> take(player, ui);
        case "drop" -> drop(player, ui);
        case "look" -> look(player, ui);
        case "help" -> ui.getHelpMenu();
        case "exit" -> running = false;
        case "health" -> health(player, ui);
        case "equip" -> equip(player, ui);
        case "use" -> use(player, ui);
        case "deequip" -> player.deEquip();
        case "weapon" -> weapon(player, ui);
        case "talk" -> talk(player, ui);
        case "give" -> give(player, ui);
        case "attack" -> attackSequence(player, ui);
        case "eat" -> eat(player, ui);
        case "inspect" -> inspect(player, ui);
      }
    }
  }

  public void look(Player player, UserInterface ui) {
    ui.printString("Narrator:");
    try {
      ui.printOneLetterAtATime(player.getCurrentRoom().getDescription(), 0.05);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    if (player.getCurrentRoom().getNPC() != null) {
      ui.printString(player.getCurrentRoom().getNPC().getNpcName());
    }
  }

  public void attackSequence(Player player, UserInterface ui) {
    if (player.getCurrentRoom().getEnemy().getDescription().equals("Wasp")){
      playWaspSong();
    }
    ui.printString("Narrator:");
    try {
      ui.printOneLetterAtATime(player.currentRoom.getEnemy().getDescription() + " Attacks!", 0.05);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    boolean engaged = true;
    int counter = 0;
    if (player.getCurrentRoom().getEnemy() != null) {
      while (engaged) {
        if (player.getHealth() > 0) {
          if (player.getEquippedWeapon() instanceof RangedWeapon tmpWeapon) {
            int tmpAmmo = tmpWeapon.getAmmo();
            if (tmpAmmo > 0) {
              tmpAmmo--;
              tmpWeapon.setAmmo(tmpAmmo);
              player.attack();
              ui.printString("You have " + tmpAmmo + " arrows left");
            } else {
              ui.printString("You're out of ammunition!");
            }
          } else {
            player.attack();
          }
        } else if (player.getHealth() <= 0) {
          engaged = false;
          ui.printString("You have been killed. The game is over.");
        }
        if (player.getCurrentRoom().getEnemy().getHealth() > 0) {
          player.takeDamage(player.getCurrentRoom().getEnemy().attack());
          ui.printString("You have " + player.getHealth() + " health left.");
        } else if (player.getCurrentRoom().getEnemy().getHealth() <= 0) {
          player.getCurrentRoom().addToInventory(player.getCurrentRoom().getEnemy().dropWeapon());
          if (player.getCurrentRoom().getEnemy().getDescription() == "Wasp"){
            player.getCurrentRoom().addToBoxes(new Box("crate", new Item("hatch key"), false, null, "The lid creaks as it opens.\n" +
                "A hatch key was inside. You take it"));
                stopWaspSong();
          }
          player.getCurrentRoom().setEnemy(null);
          ui.printString("Your enemy has been defeated.");
          engaged = false;
        }
        boolean endTurn = true;
        counter++;
        while (endTurn) {
          ui.printString("End of round " + counter);
          ui.printString("Do you wish 'equip' another weapon, 'disengage' or 'end turn'?");
          String combatAction = ui.getUserInput();
          switch (combatAction) {
            case "equip" -> equip(player, ui);
            case "disengage" -> {
              engaged = false;
              endTurn = false;
              ui.printString(player.getCurrentRoom().getEnemy().getDescription() + " gets in another hit while you run away.");
              player.getCurrentRoom().getEnemy().attack();
            }
            case "end turn" -> endTurn = false;
          }

        }
      }
    } else {
      ui.printString("Narrater: ");
      try {
        ui.printOneLetterAtATime("Who are you attacking? There's no one there.", 0.05);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void health(Player player, UserInterface ui) {
    ui.printString("Health: " + player.getHealth());
    if (player.getHealth() <= 50) {
      ui.printString("Narrator: ");
      try {
        ui.printOneLetterAtATime("You look alive enough, but i wouldn't wrestle a bear in your condition", 0.05);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void weapon(Player player, UserInterface ui) {
    if (player.getEquippedWeapon() != null) {
      if (player.getEquippedWeapon() instanceof RangedWeapon) {
        ui.printString(player.getEquippedWeapon() + ", Damage: " + player.getEquippedWeapon().getMinDamage() + " - " + player.getEquippedWeapon().getMaxDamage() + ", Ammo: " + ((RangedWeapon) player.getEquippedWeapon()).getAmmo());
      } else if (player.getEquippedWeapon() instanceof MeleeWeapon) {
        ui.printString(player.getEquippedWeapon() + ", Damage: " + player.getEquippedWeapon().getMinDamage() + " - " + player.getEquippedWeapon().getMaxDamage());
      }
    } else {
      ui.printString("You have no weapon equipped.");
    }
  }


  public void inspect(Player player, UserInterface ui) {
    boolean found = false;
    Inspectables tmpInspectable = null;
    ui.printString("What do you want to inspect?");
    String inspect = ui.getUserInput();
    for (int i = 0; i < player.getCurrentRoom().getInspectables().size(); i++) {
      if (player.getCurrentRoom().getInspectables().get(i).getDescription().equals(inspect)) {
        found = true;
        tmpInspectable = player.getCurrentRoom().getInspectables().get(i);
      }
    }

    if (!found) {
      ui.printString("Narrator:");
      try {
        ui.printOneLetterAtATime("There is nothing like that here", 0.05);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    if (found) {
      if (tmpInspectable.getDescription().equals("crate")) {
        try {
          new FunnyBeeEncounter().execute();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        player.getCurrentRoom().setEnemy(new Enemy("Wasp", 30, new MeleeWeapon("stinger", 1, 2), true));
      } else {
        ui.printString("Narrator:");
        try {
          ui.printOneLetterAtATime(tmpInspectable.getInspectMessage(), 0.05);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }

  }

  public void equip(Player player, UserInterface ui) {
    ui.printString("What do you want to equip?");
    String weapon = ui.getUserInput();
    boolean found = false;
    for (int i = 0; i < player.getPlayerInventory().size(); i++) {
      if (player.getPlayerInventory().get(i).getDescription().equalsIgnoreCase(weapon)) {
        found = true;
        if (player.getPlayerInventory().get(i) instanceof Weapon) {
          Weapon foundWeapon = (Weapon) player.getPlayerInventory().get(i);
          player.setEquippedWeapon(foundWeapon);
        } else {
          ui.printString("That's not a weapon!");
        }
      }
    }
    if (!found) {
      ui.printString("You don't have that");
    }
  }

  public void open(Player player, UserInterface ui) {

    ui.printString("What do you want to open?");
    String find = ui.getUserInput();
    boolean found = false;
    for (int i = 0; i < player.getCurrentRoom().getDoors().size(); i++) {
      if (player.getCurrentRoom().getDoors().get(i).getDescription().equalsIgnoreCase(find)) {
        found = true;
        Door tmpDoor = player.getCurrentRoom().getDoors().get(i);
        if (tmpDoor.getLocked()) {
          if (tmpDoor instanceof CodeDoor) {
            ui.printString("Narrator:");
            try {
              ui.printOneLetterAtATime("This door needs a password!", 0.05);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            ui.printString("Password: ");
            String code = ui.getUserInput();
            if (code.equals(((CodeDoor) tmpDoor).getCode())){
              tmpDoor.unlockDoor();
            } else {
              ui.printString("Narrator:");
              try {
                ui.printOneLetterAtATime("Wrong password!", 0.05);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
          } else {
            ui.printString("The door is locked!");
          }
        } else {
          player.setCurrentRoom(tmpDoor.getLeadsTo());
        }
      }
    }
    if (!found) {
      for (int i = 0; i < player.getCurrentRoom().getBoxes().size(); i++) {
        if (player.getCurrentRoom().getBoxes().get(i).getDescription().equalsIgnoreCase(find)) {
          found = true;
          Box tmpBox = player.getCurrentRoom().getBoxes().get(i);
          if (tmpBox.getLocked()) {
            ui.printString("The " + tmpBox.getDescription() + " is locked!");
          } else {
            player.getPlayerInventory().add(tmpBox.getContains());
          }
        }
      }
    }
  }

  public void take(Player player, UserInterface ui) {
    boolean containsItem = false;
    ui.printString("What do you want to take?");
    String take = ui.getUserInput();
    for (int i = 0; i < player.getCurrentRoom().getMapInventory().size(); i++) {
      if (player.getCurrentRoom().getMapInventory().get(i).getDescription().equalsIgnoreCase(take)) {
        player.takeItem(player.getCurrentRoom(), player.getCurrentRoom().getMapInventory().get(i));
        containsItem = true;
      }
    }
    if (!containsItem) {
      ui.printString("This item does not exist");
    }
  }

  public void use(Player player, UserInterface ui) {
    ui.printString("What do you want to use?");
    String keyItem = ui.getUserInput();
    Item tmpKey = null;
    boolean found = false;
    Door tmpDoor;
    Box tmpBox = null;
    boolean isBox = false;

    for (int i = 0; i < player.getPlayerInventory().size(); i++) {
      if (player.getPlayerInventory().get(i).getDescription().equalsIgnoreCase(keyItem)) {
        tmpKey = player.getPlayerInventory().get(i);
        found = true;
      }
    }
    if (!found) {
      for (int i = 0; i < player.getCurrentRoom().getBoxes().size(); i++) {
        if (player.getCurrentRoom().getBoxes().get(i).getDescription().equalsIgnoreCase(keyItem)) {
          found = true;
          isBox = true;
          tmpBox = player.getCurrentRoom().getBoxes().get(i);
          if (!tmpBox.getLocked()) {
            ui.printString("Narrator: ");
            try {
              ui.printOneLetterAtATime(tmpBox.getUnlockMessage(), 0.05);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            player.getPlayerInventory().add(tmpBox.getContains());
          }
        }
      }
    }

    if (!found) {
      ui.printString("You do not have that item!");
    }
    if (!isBox) {
      found = false;
      isBox = false;
      ui.printString("What do you want to use it on?");
      String keySlot = ui.getUserInput();
      for (int i = 0; i < player.currentRoom.getDoors().size(); i++) {
        if (player.currentRoom.getDoors().get(i).getDescription().equalsIgnoreCase(keySlot)) {
          found = true;
          tmpDoor = player.currentRoom.getDoors().get(i);
          if (tmpDoor.getKey().equalsIgnoreCase(keyItem)) {
            tmpDoor.unlockDoor();
            player.getPlayerInventory().remove(tmpKey);
          } else {
            ui.printString("Narrator:");
            try {
              ui.printOneLetterAtATime("That won't do it", 0.05);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }

      if (!found) {
        for (int i = 0; i < player.currentRoom.getBoxes().size(); i++) {
          if (player.currentRoom.getBoxes().get(i).getDescription().equalsIgnoreCase(keySlot)) {
            found = true;
            tmpBox = player.currentRoom.getBoxes().get(i);
            if (tmpBox.getKey().equalsIgnoreCase(keyItem)) {
              player.getPlayerInventory().add(tmpBox.getContains());
              player.getPlayerInventory().remove(tmpKey);
              ui.printString("Narrator:");
              try {
                ui.printOneLetterAtATime(tmpBox.getUnlockMessage(), 0.05);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            } else {
              ui.printString("Narrator:");
              try {
                ui.printOneLetterAtATime("That won't work", 0.05);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }

          }
        }
      }

      if (!found) {
        ui.printString("You can't use that item on that!");
      }
    }
  }

  public void drop(Player player, UserInterface ui) {
    ui.printString("What do you want to drop?");
    String drop = ui.getUserInput();
    for (int i = 0; i < player.getPlayerInventory().size(); i++) {
      if (player.getPlayerInventory().get(i).getDescription().equalsIgnoreCase(drop)) {
        player.dropItem(player.getCurrentRoom(), player.getPlayerInventory().get(i));
      } else {
        ui.printString("This item does not exist");
      }
    }
  }

  public void eat(Player player, UserInterface ui) {
    ui.printString("What do you want to eat?");
    String food = ui.getUserInput();
    boolean found = false;
    for (int i = 0; i < player.getPlayerInventory().size(); i++) {
      if (player.getPlayerInventory().get(i).getDescription().equals(food)) {
        found = true;
        if (player.getPlayerInventory().get(i) instanceof Food) {
          Food foundFood = (Food) player.getPlayerInventory().get(i);
          player.eat(foundFood);
          player.getPlayerInventory().remove(foundFood);
        } else {
          ui.printString("That's not edible!");
        }
      }
    }
    if (!found) {
      ui.printString("You do not have that");
    }
  }

  public void talk(Player player, UserInterface ui) {
    ui.printString("Who or what do you want to talk to?");
    String talk = ui.getUserInput();
    if (player.getCurrentRoom().getNPC() == null) {
      ui.printString("You can't do that.");
    } else if (player.getCurrentRoom().getNPC().getNpcName().equalsIgnoreCase(talk)) {
      try {
        ui.printOneLetterAtATime(player.getCurrentRoom().getNPC().dialogue(player.getCurrentRoom()), 0.05);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    if(player.getCurrentRoom().getNPC().getNpcName().equals("captain")){
      player.getCurrentRoom().getNPC().turnHostile(player.currentRoom);}
  }

  public void give(Player player, UserInterface ui) {
    ui.printString("What do you want to give?");
    String give = ui.getUserInput();
    for (int i = 0; i < player.playerInventory.size(); i++) {
      if (player.playerInventory.get(i).getDescription().equalsIgnoreCase(give)) {
        ui.printString("Who do you want to give it to?");
        String receiver = ui.getUserInput();
        if (player.getCurrentRoom().getNPC() == null) {
          ui.printString("You can't give anything to that!");
        } else if (player.getCurrentRoom().getNPC().getNpcName().equalsIgnoreCase(receiver)) {
          ui.printString(player.getCurrentRoom().getNPC().NpcRecieve(player.playerInventory.get(i), player.getCurrentRoom()));
          player.removeItem(player.playerInventory.get(i));
        }

      }
    }
  }


  public boolean checkTake(String input) {
    return getPrefix(input).equals("take");
  }

  public int getSpace(String input) {
    return input.indexOf(" ");
  }

  public String getPrefix(String input) {
    return input.substring(0, getSpace(input));
  }


  public void stopNarratorTheme() {
        clip.stop();
        clip.close();
  }

  public void playNarratorTheme() {
    try {
      String musicLocation = "getThatPotion.wav";
      File musicPath = new File(musicLocation);
      if (musicPath.exists()) {
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInput);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);

        long clipTimePosition = clip.getMicrosecondPosition();
        clip.stop();

        clip.setMicrosecondPosition(clipTimePosition);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);

      } else {
        System.out.println("Can't find file");
      }
    } catch (Exception ex) {
      ex.printStackTrace();

    }
  }

  public void playWaspSong() {
    try {
      String musicLocation = "notABee.wav";
      File musicPath = new File(musicLocation);
      if (musicPath.exists()) {
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInput);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);

        long clipTimePosition = clip.getMicrosecondPosition();
        clip.stop();

        clip.setMicrosecondPosition(clipTimePosition);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);

      } else {
        System.out.println("Can't find file");
      }
    } catch (Exception ex) {
      ex.printStackTrace();

    }
  }

  public void stopWaspSong() {
    try {
      String musicLocation = "notABee.wav";
      File musicPath = new File(musicLocation);
      if (musicPath.exists()) {
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInput);
        clip.stop();

      } else {
        System.out.println("Can't find file");
      }
    } catch (Exception ex) {
      ex.printStackTrace();

    }
  }

  public String getUserSuffix(String input) {
    int space = getSpace(input);
    return input.substring(space + 1);
  }
}

