package jar;

import java.util.Scanner;

// UpgradedGame class that extends Game class without changing the core structure of the Game class
public class UpgradedGame extends Game {
    private final int numOfMarkers; // numOfMarkers for the game

    public UpgradedGame(Board UpgradedBoard, Player player1, Player player2, int numOfMarkers) { // constructor
        super(UpgradedBoard, player1, player2);
        this.numOfMarkers = numOfMarkers;
    }

    // main method to run the game
    public static void main(String[] args) {
        Player player1 = null; // Initialize players and ints
        Player player2 = null;
        int size;
        int numOfMarkers;

        // Print welcome message and game mode options
        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Choose your game mode:");
        System.out.println("1. Human vs Human");
        System.out.println("2. Human vs Computer");
        System.out.println("3. Computer vs Computer");
        System.out.println("Enter the number of your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        System.out.println("Enter the size of the board (3 <= N <= 20): ");
        size = scanner.nextInt();
        if (size < 3 || size > 20) { // Check if the size is valid
            System.out.println("Invalid size. Exiting...");
            System.exit(0);
        }
        System.out.println("Enter the number of markers to win M <= N: ");
        numOfMarkers = scanner.nextInt();
        if (numOfMarkers > size) { // Check if the number of markers is valid
            System.out.println("Invalid number of markers. Exiting...");
            System.exit(0);
        }

        if (choice == 1) { // initialize players based on choice
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

        Game game = new UpgradedGame(new UpgradedBoard(size, numOfMarkers), player1, player2, numOfMarkers);
        game.run();
    }
}