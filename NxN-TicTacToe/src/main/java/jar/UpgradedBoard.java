package jar;

// UpgradedBoard class that extends Board class and accepts a size and numOfMarkers for the board
// This class overrides the placeMove, isFull, endGame, and showBoard methods without changing the core structure of the Board class
public class UpgradedBoard extends Board {
    private final int size; // size of the board
    private final int numOfMarkers; // numOfMarkers for the board


    public UpgradedBoard(int size, int numOfMarkers) { // constructor
        super(size);
        this.size = size;
        this.numOfMarkers = numOfMarkers;
    }

    @Override
    public boolean placeMove(int row, int col, char symbol) { // place a move
        if (row >= 0 && row < size && col >= 0 && col < size && isEmpty(row, col)) {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    @Override
    public boolean isFull() { // check if the board is full
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int endGame(char symbol) { // check if the game has ended
        int not_end = 0;
        int player_1_win = 1;
        int player_2_win = 2;
        int draw = 3;
        boolean hasWon = false;

        // Check rows for a win
        for (int row = 0; row < grid.length; row++) {
            int count = 0; // Reset count for each row
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == symbol) {
                    count++; // Increment if the cell matches the symbol
                    if (count == numOfMarkers) {
                        hasWon = true;
                        break;
                    }
                } 
                else {
                    count = 0; // Reset count if a non-matching cell is encountered
                }
            }
            if (hasWon) {
                break;
            }
        }

        // Check columns for a win
        if (!hasWon) {
            for (int col = 0; col < grid[0].length; col++) {
                int count = 0; // Reset count for each column
                for (int row = 0; row < grid.length; row++) {
                    if (grid[row][col] == symbol) {
                        count++; // Increment if the cell matches the symbol
                        if (count == numOfMarkers) {
                            hasWon = true;
                            break;
                        }
                    } 
                    else {
                        count = 0; // Reset count if a non-matching cell is encountered
                    }
                }
                if (hasWon) {
                    break;
                }
            }
        }

        // Check diagonals (top-left to bottom-right)
        if (!hasWon) {
            for (int startRow = 0; startRow <= grid.length - numOfMarkers; startRow++) {
                for (int startCol = 0; startCol <= grid[0].length - numOfMarkers; startCol++) {
                    int count = 0;
                    for (int i = 0; i < numOfMarkers; i++) {
                        if (startRow + i < grid.length && startCol + i < grid[0].length && grid[startRow + i][startCol + i] == symbol) {
                            count++;
                            if (count == numOfMarkers) {
                                hasWon = true;
                                break;
                            }
                        } 
                        else {
                            count = 0; // Reset count
                            break; // Exit loop early for non-matching cell
                        }
                    }
                    if (hasWon) {
                        break;
                    } 
                }
                if (hasWon) {
                    break;
                } 
            }
        }

        // Check diagonals (top-right to bottom-left)
        if (!hasWon) {
            for (int startRow = 0; startRow <= grid.length - numOfMarkers; startRow++) {
                for (int startCol = numOfMarkers - 1; startCol < grid[0].length; startCol++) {
                    int count = 0;
                    for (int i = 0; i < numOfMarkers; i++) {
                        if (startRow + i < grid.length && startCol - i >= 0 && grid[startRow + i][startCol - i] == symbol) {
                            count++;
                            if (count == numOfMarkers) {
                                hasWon = true;
                                break;
                            }
                        } 
                        else {
                            count = 0; // Reset count
                            break; // Exit loop early for non-matching cell
                        }
                    }
                    if (hasWon) {
                        break;
                    }
                }
                if (hasWon) {
                    break;
                }
            }
        }

        // Check if player has won
        if (hasWon) {
            return (symbol == 'X') ? player_1_win : player_2_win; // Return the player who has won    
            }

        // Check for a draw
        if (isFull()) {
            return draw; // Return draw
        }

        return not_end; // Return not_end if the game is not over
    }

    @Override
    public void showBoard() { // print the board
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]); // print the cell
                if (j < grid[i].length - 1) System.out.print(" | "); // print the separator
            }
            System.out.println(); // print a new line
            if (i < grid.length - 1) { // print the line separator
                for (int j = 0; j < grid[i].length; j++) {
                    System.out.print("----");
                }
                System.out.println();
            }
        }
    }

}