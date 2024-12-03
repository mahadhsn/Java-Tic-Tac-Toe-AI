package jar;

import java.util.Random;

// ComputerPlayer class
public class ComputerPlayer extends Player {
    private final Random random; // random number generator

    public ComputerPlayer(char symbol) { // constructor
        super(symbol);
        this.random = new Random();
    }

    @Override
    public int[] getMove(Board board) { // get the move

        int[] move = new int[2];
        int size = board.getSize();
        move[0] = random.nextInt(size); // generate a random number for the row
        move[1] = random.nextInt(size); // generate a random number for the column
        if (board.isEmpty(move[0], move[1])) {
            return move;
        }
        else {
            return getMove(board); // recursively call the method until a valid move is found
        }
    }
}