package jar;

import java.util.Scanner;

public class BasicGame extends Game {

    public BasicGame(Board board, Player player1, Player player2) { // constructor
        super(board, player1, player2);
    }

    // main method to run the game
    public static void main(String[] args) {
        Player player1 = null; // initialize players
        Player player2 = null;

        // print welcome message and game mode options
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Choose your game mode:");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.println("3. Computer vs Computer");
        System.out.println("Enter the number of your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        
        if (choice == 1) { // set players based on choice
            player1 = new HumanPlayer('X');
            player2 = new HumanPlayer('O');
        }
        else if (choice == 2) {
            player1 = new HumanPlayer('X');
            player2 = new ComputerPlayer('O');
        }
        else if (choice == 3) {
            player1 = new ComputerPlayer('X');
            player2 = new ComputerPlayer('O');
        }
        else {
            System.out.println("Invalid choice. Exiting...");
            System.exit(0);
        }

        Game game = new BasicGame(new BasicBoard(), player1, player2);
        game.run();
    }
}