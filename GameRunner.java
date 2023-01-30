/**
 * Project 2.5.11
 *
 * GameRunner Class for the Game of Nim
*/

import java.util.Scanner;
public class GameRunner
{
  private static String playAgain = "y";

  public static void main(String[] args)
  {
    System.out.println("Welcome to the Game of Nim!");
    Game nim = new Game();
    while (playAgain.toLowerCase().equals("y")) {

      nim.empty = false;
      nim.play();
      System.out.println("Would you like to play again? (Y/N)");
      Scanner sc = new Scanner(System.in);
      playAgain = sc.nextLine();
    }
    System.out.println("Thanks for playing Nim!");
  }
}