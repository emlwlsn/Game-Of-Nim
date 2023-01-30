import java.util.Scanner;

public class Game {

    private Player player1;
    private Player player2;
    private Board game;
    boolean empty;

    public Game() 
    {
        player1 = new Player();
        player2 = new Player();
        game = new Board();
        empty = false;
    }
    
    public void play()
    {
        int currentPlayer = 1; // set current player to Player 1
        int piecesTakenAway;
        boolean validAmount = false;

        Scanner sc = new Scanner(System.in);
        
        game.populate();
        // stop the game if the phrase is empty
        while (!empty) {
            System.out.println("There are currently " + game.pieces + " pieces on the board");
            if (currentPlayer == 1) {
                System.out.println(player1.getName() + ", pick at most " + (game.pieces/2) + " pieces to remove from the board:");
                piecesTakenAway = sc.nextInt();
                if (piecesTakenAway <= (game.pieces / 2) && piecesTakenAway >= 1) {
                    validAmount = true;
                    game.subtractPieces(piecesTakenAway);
                    currentPlayer = 2;
                } else {
                    validAmount = false;
                }
                while (!validAmount) {
                    System.out.println("Please enter a number less than " + (game.pieces/2 + 1) + " and greater than 1:");
                    piecesTakenAway = sc.nextInt();
                    if (piecesTakenAway <= (game.pieces / 2) && piecesTakenAway >= 1) {
                        validAmount = true;
                        game.subtractPieces(piecesTakenAway);
                        currentPlayer = 2;
                    }
                }
            } else {
                System.out.println(player2.getName() + ", pick at most " + (game.pieces/2) + " pieces to remove from the board:");
                piecesTakenAway = sc.nextInt();
                if (piecesTakenAway <= (game.pieces / 2) && piecesTakenAway >= 1) {
                    validAmount = true;
                    game.subtractPieces(piecesTakenAway);
                    currentPlayer = 1;
                } else {
                    validAmount = false;
                }
                while (!validAmount) {
                    System.out.println("Please enter a number less than " + (game.pieces/2) + " and greater than 1:");
                    piecesTakenAway = sc.nextInt();
                    if (piecesTakenAway <= (game.pieces / 2) && piecesTakenAway >= 1) {
                        validAmount = true;
                        game.subtractPieces(piecesTakenAway);
                        currentPlayer = 1;
                    }
                }
            }
            if (game.pieces <= 2) {
                if (currentPlayer == 1) {
                    player2.wins += 1;
                    System.out.println(player1.getName() + ", there are not enough pieces left for you to take.");
                    System.out.println("Congratulations " + player2.getName() + ", you have won the game of Nim!");
                    System.out.println(player2.getName() + ", you know have " + player2.getWins() + " wins!");  
                    empty = true; 
                } else {
                    player1.wins += 1;
                    System.out.println(player2.getName() + ", there are not enough pieces left for you to take.");
                    System.out.println("Congratulations " + player1.getName() + ", you have won the game of Nim!");
                    System.out.println(player1.getName() + ", you now have " + player1.getWins() + " wins!");   
                    empty = true;
                }

                // System.out.println("Would you like to play again (Y/N)?");
                // playAgain = sc.nextLine();
                // while(playAgain.toLowerCase() == "y" || playAgain == "n") {
                //     if (playAgain.toLowerCase() == "y") {
                //         play();
                //     } else if (playAgain.toLowerCase() == "n") {
                //         System.out.println("Thanks for playing Nim!");
                //         empty = true;
                //     } else {
                //         System.out.println("Please enter either Y (yes) or N (no)");
                //     }
                // }
                
            }
        }
    }
}
        