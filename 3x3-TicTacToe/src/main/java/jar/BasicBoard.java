package jar;

// BasicBoard class that extends Board class | creates a basic 3x3 board
public class BasicBoard extends Board {

    public BasicBoard() { // constructor
        super(3);
    }

    @Override
    public boolean placeMove(int row, int col, char symbol) { // place a move
        if (grid[row][col] == ' ' || symbol == ' ') { // Allow undo when symbol is empty
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
    public int endGame(char symbol) { // check if the player has won
        int not_end = 0;
        int player_1_win = 1;
        int player_2_win = 2;
        int draw = 3;
        int result = not_end;
        
        // check rows
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) {
                result = symbol == 'X' ? player_1_win : player_2_win;
            }
        }

        // check columns
        for (int i = 0; i < grid.length; i++) {
            if (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) {
                result = symbol == 'X' ? player_1_win : player_2_win;
            }
        }

        // check diagonals
        if (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) {
            result = symbol == 'X' ? player_1_win : player_2_win;
        }
        if (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol) {
            result = symbol == 'X' ? player_1_win : player_2_win;
        }

        // check if the board is full
        if (isFull() && result == not_end) {
            result = draw;
        }

        return result;
    }

    @Override
    public void showBoard() { // print the board
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(" " + grid[i][j] + " ");
                if (j < grid[i].length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < grid.length - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }
}