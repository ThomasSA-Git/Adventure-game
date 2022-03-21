package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

  Scanner sc = new Scanner(System.in);

  public String getUserInput(){

    return sc.nextLine();
  }


  public void printOneLetterAtATime(String text, double speed) throws InterruptedException {
    for (int i = 0; i < text.length(); i++) {
      System.out.print(String.valueOf(text.charAt(i)));
      Thread.sleep((long) (speed * 1000L));
    }
    System.out.println("\n");
  }

  public void presentGame() {
    System.out.println("""
        WELCOME TO <placeholder>
        You can always write 'help' to see a list of commands
        """);
  }

  public void getHelpMenu() {
    System.out.println("""
        ---------HELP MENU---------
        go <direction>: Moves your character to the next room in chosen location
        look: Look around (You might find something interesting)
        take: Pick up item and put in your inventory
        drop: Drop item from inventory on ground
        inventory: Get a list of your inventory
        
        help: Display this menu
        exit: Close game
        """);
  }

  public void blockedDirection(){
    System.out.println("You can't go this way.");
  }

  public void currentRoom(){
   // System.out.println("You're currently in room" + cr.currentRoom);
  }

  public void lockedDoor() {
    System.out.println("      ______\n" +
        "   ,-' ;  ! `-.\n" +
        "  / :  !  :  . \\\n" +
        " |_ ;   __:  ;  |\n" +
        " )| .  :)(.  !  |\n" +
        " |\"    (##)  _  |\n" +
        " |  :  ;`'  (_) (\n" +
        " |  :  :  .     |\n" +
        " )_ !  ,  ;  ;  |\n" +
        " || .  .  :  :  |\n" +
        " |\" .  |  :  .  |\n" +
        " |____;----.____|");
    System.out.println("You can't go this direction. The door is locked.");
  }

  public void printCurrentRoom(Room currentRoom){

    System.out.println(currentRoom);
  }

  public void printList(ArrayList<Item> print){
    System.out.println(print);
  }

}
