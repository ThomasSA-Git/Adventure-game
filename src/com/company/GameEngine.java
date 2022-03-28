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
        }
        case "help" -> ui.getHelpMenu();
        case "exit" -> running = false;
        case "health" -> {
          ui.printString("Health: " + player.getHealth());
          if (player.getHealth() <= 50){
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
          for (int i = 0; i < player.getPlayerInventory().size(); i++){
            if (player.getPlayerInventory().get(i).getDescription().equals(weapon)){
              found = true;
              Weapon foundWeapon = (Weapon) player.getPlayerInventory().get(i);
              player.equip(foundWeapon);
            }
          }
        }

        case "deequip" -> player.deEquip();

        case "weapon" -> ui.printString(player.getEquippedWeapon() + ", Damage: " + player.getEquippedWeapon().getMinDamage() + " to " + player.getEquippedWeapon().getMaxDamage());

        case "attack" -> {
          boolean engaged = true;
          if (player.getCurrentRoom().getEnemy() != null) {
          while(engaged){
            if(player.getHealth() > 0){
            player.attack();}
            else if (player.getHealth() <= 0){
              engaged = false;
              ui.printString("You have been killed. The game is over.");
              //End game?
            }
            if(player.getCurrentRoom().getEnemy().getHealth() > 0){
            player.getCurrentRoom().getEnemy().attack();
            ui.printString("you have " + player.getHealth() + " health left.");}
            else if(player.getCurrentRoom().getEnemy().getHealth() <= 0){
              engaged = false;
              ui.printString("Your enemy has been defeated.");
            }
          }
          }
          else if(player.getCurrentRoom().getEnemy() == null){
            ui.printString("Who are you attacking? There's no one there.");
          }
        }
        case "eat" -> {
          ui.printString("What do you want to eat?");
          String food = ui.getUserInput();
          boolean found = false;
          for (int i = 0; i < player.getPlayerInventory().size(); i++) {
            if (player.getPlayerInventory().get(i).getDescription().equals(food)) {
              found = true;
              Food foundFood = (Food) player.getPlayerInventory().get(i);
              player.eat(foundFood);
              player.getPlayerInventory().remove(foundFood);
            }
            if (!found) {
              ui.printString("You can't eat that!");
            }
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

