package jar;
import java.util.Scanner;

// HumanPlayer class
public class HumanPlayer extends Player {

    public HumanPlayer(char symbol) { // constructor
        super(symbol);
    }

    @Override
    public int[] getMove(Board board) { // get the move
        int[] move = new int[2];
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Enter the [ROW] and [COLUMN] number ( 0 - " + (board.getSize() - 1) +" ) separated by a space or type 'r' to restart the game: "); // prompt the user
        if (scanner.hasNextInt()) {
            move[0] = scanner.nextInt();
            move[1] = scanner.nextInt();
        } else if (scanner.next().equalsIgnoreCase("r")) {
            move = new int[]{-1, -1}; // special value to indicate restart
        }
        System.out.println(); // print a new line for formatting
        return move;
    }
}