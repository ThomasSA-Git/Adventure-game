package com.company;

import java.util.Scanner;

public class UserInterface {

  Scanner sc = new Scanner(System.in);

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

}
