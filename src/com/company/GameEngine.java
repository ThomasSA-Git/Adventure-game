package com.company;

public class GameEngine {

  public void runGame() {
    Creator creator = new Creator();
    UserInterface ui = new UserInterface();
    creator.createRooms();
    Player player = new Player(creator.firstRoom);
    ui.presentGame();

    boolean running = true;
    while (running) {

      ui.printCurrentRoom(player.getCurrentRoom());

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
      }
    }
  }

  public void look(Player player, UserInterface ui) {
    ui.printString(player.getCurrentRoom().getDescription());
    ui.printString("The following items are in the area:");
    ui.printList(player.getCurrentRoom().getMapInventory());
    if (player.getCurrentRoom().getNPC() != null) {
      ui.printString(player.getCurrentRoom().getNPC().getNpcName());
    }
  }

  public void attackSequence(Player player, UserInterface ui) {
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
              engaged = false;
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
    } else if (player.getCurrentRoom().getEnemy() == null) {
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
      try {
        ui.printOneLetterAtATime("Narrator: You look alive enough, but i wouldn't wrestle a bear in your condition", 0.05);
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
    String door = ui.getUserInput();
    boolean found = false;
    for (int i = 0; i < player.getCurrentRoom().getDoors().size(); i++) {
      if (player.getCurrentRoom().getDoors().get(i).getDescription().equalsIgnoreCase(door)) {
        found = true;
        Door tmpDoor = player.getCurrentRoom().getDoors().get(i);
        if (tmpDoor.getLocked()) {
          ui.printString("Door is locked!");
        } else {
          player.setCurrentRoom(tmpDoor.getLeadsTo());
        }
      }
      if (!found) {
        ui.printString("There is nothing like that to open");
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
    boolean found = false;
    Door tmpDoor;

    for (int i = 0; i < player.getPlayerInventory().size(); i++) {
      if (player.getPlayerInventory().get(i).getDescription().equalsIgnoreCase(keyItem)) {
        found = true;
      }
    }
    if (!found) {
      ui.printString("You do not have that item!");
    }
    found = false;
    ui.printString("What do you want to use it on?");
    String keySlot = ui.getUserInput();
    for (int i = 0; i < player.currentRoom.getDoors().size(); i++) {
      if (player.currentRoom.getDoors().get(i).getDescription().equalsIgnoreCase(keySlot)) {
        found = true;
        tmpDoor = player.currentRoom.getDoors().get(i);
        tmpDoor.unlockDoor();
      }
    }
    if (!found) {
      ui.printString("You can't use that item on that!");
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
    if (player.getCurrentRoom().getNPC().getNpcName().equalsIgnoreCase(talk)) {
      ui.printString(player.getCurrentRoom().getNPC().dialogue());
    } else {
      ui.printString("That doesn't talk");
    }
  }

  public void give(Player player, UserInterface ui) {
    ui.printString("What do you want to give?");
    String give = ui.getUserInput();
    for (int i = 0; i < player.playerInventory.size(); i++) {
      if (player.playerInventory.get(i).getDescription().equalsIgnoreCase(give)) {
        ui.printString("Who do you want to give it to?");
        String receiver = ui.getUserInput();
        if (player.getCurrentRoom().getNPC().getNpcName().equalsIgnoreCase(receiver)) {
          ui.printString(player.getCurrentRoom().getNPC().NpcRecieve(player.playerInventory.get(i), player.getCurrentRoom()));
          player.removeItem(player.playerInventory.get(i));
        } else {
          ui.printString("You can't give anything to that!");
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

  public String getUserSuffix(String input) {
    int space = getSpace(input);
    return input.substring(space + 1);
  }
}

