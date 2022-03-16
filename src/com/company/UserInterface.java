package com.company;

import java.util.Scanner;


public class UserInterface {
  Scanner sc = new Scanner(System.in);
  Creator creator = new Creator();

public void printOneLetterAtATime(String text, double speed) throws InterruptedException {
        for (int i = 0; i < text.length(); i++){
        System.out.printf(String.valueOf(text.charAt(i)));
        Thread.sleep((long) (speed * 1000L));
        }
        System.out.println("\n");
        }

  public String getUserInput(){

    return sc.nextLine();
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
        help: Display this menu
        exit: Close game
        """);
  }

  public void blockedDirection(){
    System.out.println("You can't go this way.");
  }

  public void currentRoom(){
    System.out.println("You're currently in room" + creator.getCurrentRoom());
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

  public void printCurrentRoom(){
    System.out.println(creator.getCurrentRoom());
  }

}
