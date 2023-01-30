import java.util.Scanner;

public class Player {
    private String name;
    int wins;

    public Player()
    {
      Scanner sc = new Scanner(System.in);
      
      System.out.println("Enter Player Name: ");
      String newName = sc.nextLine();
     
      name = newName;
      System.out.println("Hello and welcome to the game, " + getName());
    }

    public String getName()
    {
        return name;
    }

    public int getWins() {
        return wins;
    }
}
