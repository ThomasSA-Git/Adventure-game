package com.company.frontend;

import com.company.backend.RoomCreator;

import java.util.Scanner;


public class UserInterface {
  Scanner sc = new Scanner(System.in);
  RoomCreator roomCreator = new RoomCreator();


  public void printOneLetterAtATime(String text, double speed) throws InterruptedException {
    for (int i = 0; i < text.length(); i++) {
      System.out.print(String.valueOf(text.charAt(i)));
      Thread.sleep((long) (speed * 1000L));
    }
    System.out.println("\n");
  }

  public String getUserInput() {
    return sc.nextLine();
  }


  public void presentGame() {
    /*
    try {
      printOneLetterAtATime("...", 1);
      printOneLetterAtATime("...", 1);
      printOneLetterAtATime("...OH!", 0.1);
      Thread.sleep(1000);
      printOneLetterAtATime("Finally awake are we?", 0.05);
      Thread.sleep(500);
      System.out.print("Narrator: ");
      printOneLetterAtATime("I'm the narrator and i'm going to be your guide in this little adventure", 0.05);
      Thread.sleep(1000);
      System.out.print("Narrator: ");
      printOneLetterAtATime("You see... I am in quite the predecement here", 0.05);
      Thread.sleep(1000);
      System.out.print("Narrator: ");
      printOneLetterAtATime("An evil wizard has stolen one of my strongest potions, and i need it back urgently!", 0.05);
      Thread.sleep(1000);
      System.out.print("Narrator: ");
      printOneLetterAtATime("This is where you come in...", 0.05);
      Thread.sleep(1000);
      System.out.print("Narrator: ");
      printOneLetterAtATime("I need you to find this maniac, and steal it back for me!", 0.05);
      Thread.sleep(1000);
      System.out.print("Narrator: ");
      printOneLetterAtATime("What do you say?", 0.05);
      Thread.sleep(1000);
      System.out.println("Accept quest? (yes/no)");

      boolean invalidAnswer = true;

      while (invalidAnswer)
        switch (getUserInput()) {
          case "yes", "no" -> invalidAnswer = false;
          default -> {
            System.out.print("Narrator: ");
            printOneLetterAtATime("This is a yes or no question pal", 0.5);
          }
        }
      System.out.print("Narrator: ");
      printOneLetterAtATime("This is the part where i would explain the concept of illusion of choice", 0.05);
      Thread.sleep(500);
      System.out.print("Narrator: ");
      printOneLetterAtATime("BUT WE SIMPLY DO NOT HAVE TIME!", 0.01);
      Thread.sleep(300);
      System.out.print("Narrator: ");
      printOneLetterAtATime("GO GET THAT POTION! AND REMEMBER YOU CAN ALWAYS TYPE 'HELP' FOR A LIST OF COMMANDS", 0.05);
      Thread.sleep(100);
      System.out.print("Narrator: ");
      printOneLetterAtATime("I DON'T KNOW WHAT THAT MEANS BUT SOMEONE MENTIONED IT WAS IMPORTANT", 0.05);
      Thread.sleep(500);
      System.out.print("Narrator: ");
      printOneLetterAtATime("OFF YOU GO THEN!", 0.05);


    } catch (InterruptedException e) {
      e.printStackTrace();
    }

     */


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

  public void blockedDirection() {
    System.out.println("You can't go this way.");
  }

  public void currentRoom() {
    System.out.println("You're currently in room" + roomCreator.getCurrentRoom());
  }

  public void lockedDoor() {
    System.out.println("""
             ______
          ,-' ;  ! `-.
         / :  !  :  . \\
        |_ ;   __:  ;  |
        )| .  :)(.  !  |
        |"    (##)  _  |
        |  :  ;`'  (_) (
        |  :  :  .     |
        )_ !  ,  ;  ;  |
        || .  .  :  :  |
        |" .  |  :  .  |
        |____;----.____|""".indent(1));
    System.out.println("You can't go this direction. The door is locked.");
  }

  public void printCurrentRoom() {
    System.out.println(roomCreator.getCurrentRoom());
  }

}
