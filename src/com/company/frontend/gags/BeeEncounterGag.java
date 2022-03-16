package com.company.frontend.gags;

import com.company.frontend.UserInterface;

import java.util.Scanner;

  public class BeeEncounterGag {

    UserInterface ui = new UserInterface();

    public void clearConsole(){
      System.out.println("\033[H\033[2J");
    }

    public void execute() throws InterruptedException {

      Scanner sc = new Scanner(System.in);

      ui.printOneLetterAtATime("You engage the wooden crate, When suddenly you notice a small yellow creature resting on the lid", 0.05);
      Thread.sleep(1000);
      System.out.println("Press enter to continue");
      sc.nextLine();
      ui.printOneLetterAtATime("A...", 1);
      ui.printOneLetterAtATime("Bee...?", 0.2);
      Thread.sleep(1000);
      ui.printOneLetterAtATime("You squint your eyes together to make sure...", 0.05);
      Thread.sleep(1000);
      System.out.println("Press enter to continue");
      sc.nextLine();
      System.out.println("""

              .-.         .--''-.
            .'   '.     /'       `.
            '.     '. ,'          |
         o    '.o   ,'        _.-'
          \\.--./'. /.:. :._:.'
         .'    '._-': ': ': ': ':
        :(#) (#) :  ': ': ': ': ':>-
         ' ____ .'_.:' :' :' :' :'
          '\\__/'/ | | :' :' :'
                \\  \\ \\
                '  ' '
             
                """);
      Thread.sleep(1000);
      ui.printOneLetterAtATime("!!!", 0.3);
      System.out.println("Press enter to continue");
      sc.nextLine();
      ui.printOneLetterAtATime("A BEEEEEEEEEEE!!!!!!", 0.1);
      Thread.sleep(1000);
      ui.printOneLetterAtATime("The bee looks up at you with a friendly face", 0.05);
      Thread.sleep(1000);
      System.out.print("Bee: ");
      ui.printOneLetterAtATime("A bee i am...", 0.5);
      Thread.sleep(2000);
      clearConsole();
      System.out.flush();
      System.out.println("""
              .-.         .--''-.
            .'   '.     /'       `.
            '.     '. ,'          |
         o    '.o   ,'        _.-'
          \\.--./'. /.:. :._:.'
         .\\   /'._-':#0: ':#0: ':
        :(#) (#) :  ':#0: ':#0: ':>#=-
         ' ____ .'_.:J0:' :J0:' :'
          'V  V'/ | |":' :'":'
                \\  \\ \\
                '  ' '
                """);
      Thread.sleep(500);
      System.out.print("Wasp: ");
      ui.printOneLetterAtATime("NOT!", 0.2);
    }

    public static void main(String[] args) throws InterruptedException {
     new BeeEncounterGag().execute();
    }
  }

