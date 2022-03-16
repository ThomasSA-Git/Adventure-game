package com.company;

import java.util.Scanner;

  public class FunnyBeeEncounter {

    public void clearConsole(){
      System.out.println("\033[H\033[2J");
    }

    public void printOneLetterAtATime(String text, double speed) throws InterruptedException {
      for (int i = 0; i < text.length(); i++){
        System.out.printf(String.valueOf(text.charAt(i)));
        Thread.sleep((long) (speed * 1000L));
      }
    }

    public void execute() throws InterruptedException {

      Scanner sc = new Scanner(System.in);

      printOneLetterAtATime("You engage the wooden crate, When suddenly you notice a small yellow creature resting on the lid", 0.05);
      System.out.println("\n");
      printOneLetterAtATime("A...", 1);
      System.out.println("\n");
      printOneLetterAtATime("Bee...?", 0.2);
      Thread.sleep(1000);
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
      printOneLetterAtATime("A BEEEEEEEEEEE!", 0.1);
      sc.nextLine();
      System.out.print("Bee: ");
      printOneLetterAtATime("A bee i am...", 0.5);
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
      System.out.print("Wasp: ");
      printOneLetterAtATime("NOT!", 0.1);
    }

    public static void main(String[] args) throws InterruptedException {
     new FunnyBeeEncounter().execute();


    }
  }

