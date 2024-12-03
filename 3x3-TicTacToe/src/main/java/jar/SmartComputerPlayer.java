package jar;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

// SmartComputerPlayer class that extends Player class | implements the minimax algorithm
public class SmartComputerPlayer extends Player {
    private final char symbol;
    private final char opponentSymbol;

    public SmartComputerPlayer(char symbol, char opponentSymbol) { // constructor
        super(symbol);
        this.symbol = symbol;
        this.opponentSymbol = opponentSymbol;
    }


    @Override
    public int[] getMove(Board board) { // get the move
        // Run the minimax algorithm to evaluate the best move
        AtomicInteger count = new AtomicInteger(0); // Initialize count
        int[] result = minimax(board, 0, true, count);  // Start at depth 0, maximizing for computer
        int moveRow = result[1];
        int moveCol = result[2];
        int evaluatedCount = result[3];  // Total moves evaluated

        System.out.println("Total positions evaluated: " + evaluatedCount);  // Output the count

        return new int[] {moveRow, moveCol, evaluatedCount};  // Return move along with count
    }

    private int[] minimax(Board board, int depth, boolean isMaximizing, AtomicInteger count) { // minimax algorithm
        // Base case: Evaluate terminal states
        if (board.endGame(symbol) == 2) {
        return new int[] {10 - depth, count.get()}; // Computer wins
            }

        if (board.endGame(opponentSymbol) == 1) {
            return new int[] {depth - 10, count.get()}; // Opponent wins
            }   

        if (board.isFull()) {
            return new int[] {0, count.get()}; // Draw
            }

        if (isMaximizing) { // finds the best move for the computer
            int maxEval = Integer.MIN_VALUE; // Initialize maxEval to negative infinity
            int[] bestMove = new int[2]; // Store the best move

            for (int row = 0; row < board.getSize(); row++) {
                for (int col = 0; col < board.getSize(); col++) {
                    if (board.isEmpty(row, col)) { // Check if cell is empty
                        board.placeMove(row, col, symbol); // Trial move
                        count.incrementAndGet();  // Increment count safely
                        int[] result = minimax(board, depth + 1, false, count); // Recursively minimize opponent's score
                        board.placeMove(row, col, ' '); // Undo move to try other moves

                        if (result[0] > maxEval) { // Update maxEval and bestMove if a better move is found
                            maxEval = result[0]; 
                            bestMove = new int[] {row, col}; // Store the best move
                        }
                    }
                }
            }
            return new int[] {maxEval, bestMove[0], bestMove[1], count.get()}; // Return the best move along with count
        } 
        
        else { // finds the best move for the opponent
            int minEval = Integer.MAX_VALUE; // Initialize minEval to positive infinity
            int[] bestMove = new int[2]; // Store the best move

            for (int row = 0; row < board.getSize(); row++) {
                for (int col = 0; col < board.getSize(); col++) {
                    if (board.isEmpty(row, col)) { // Check if cell is empty
                        board.placeMove(row, col, opponentSymbol); // Trial move
                        count.incrementAndGet();  // Increment count safely
                        int[] result = minimax(board, depth + 1, true, count); // Recursively maximize computer's score
                        board.placeMove(row, col, ' '); // Undo move to try other moves

                        if (result[0] < minEval) { // Update minEval and bestMove if a better move is found
                            minEval = result[0]; 
                            bestMove = new int[] {row, col}; // Store the best move
                        }
                    }
                }
            }
            return new int[] {minEval, bestMove[0], bestMove[1], count.get()};
        }
    }
}