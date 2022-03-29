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
        case "inventory" -> ui.printArrayList(player.getPlayerInventory());

        case "take" -> {
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

        case "drop" -> {
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
        case "look" -> {
          ui.printString(player.getCurrentRoom().getDescription());
          ui.printList(player.getCurrentRoom().getMapInventory());
          ui.printString(player.getCurrentRoom().getNPC().getNpcName());
        }
        case "help" -> ui.getHelpMenu();
        case "exit" -> running = false;
        case "health" -> {
          ui.printString("Health: " + player.getHealth());
          if (player.getHealth() <= 50) {
            try {
              ui.printOneLetterAtATime("Narrator: You look alive enough, but i wouldn't wrestle a bear in your condition", 0.05);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }

        case "equip" -> {
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

        case "deequip" -> player.deEquip();

        case "weapon" -> {
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
        case "talk" -> {
          ui.printString("Who or what do you want to talk to?");
          String talk = ui.getUserInput();
          if (player.getCurrentRoom().getNPC().getNpcName().equalsIgnoreCase(talk)) {
            ui.printString(player.getCurrentRoom().getNPC().dialogue());
          } else {
            ui.printString("That doesn't talk");
          }
        }
        case "give" -> {
          ui.printString("What do you want to give?");
          String give = ui.getUserInput();
          for (int i = 0; i < player.playerInventory.size(); i++) {
            if (player.playerInventory.get(i).getDescription().equalsIgnoreCase(give)){

            }
          }
        }
        case "attack" -> {
          boolean engaged = true;
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
                running = false;

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
        case "eat" -> {
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

