package jar;

// Abstract Board class
public abstract class Board {
    protected char[][] grid; // inputted grid size

    public Board(int size) { // constructor
        grid = new char[size][size];
        for (char[] row : grid) {
            java.util.Arrays.fill(row, ' '); // fill the grid with empty spaces
        }
    }

    public int getSize() { // getter
        return grid.length;
    } 

    public boolean isEmpty(int row, int col) { // check if the cell is empty
        return grid[row][col] == ' ';
    }

    public void clearBoard() { // clear the board
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public char[][] getBoard() { // getter
        return grid;
    }

    public abstract boolean placeMove(int row, int col, char symbol); // place a move

    public abstract boolean isFull(); // check if the board is full

    public abstract int endGame(char symbol); // check if the player has won

    public abstract void showBoard(); // print the board

}