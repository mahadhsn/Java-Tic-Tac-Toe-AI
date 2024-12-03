package jar;

// Abstract Player class
public abstract class Player {
    protected char symbol; // X or O

    public Player(char symbol) { // constructor
        this.symbol = symbol;
    }

    public char getSymbol() { //get the symbol
        return symbol;
    }

    public abstract int[] getMove(Board board); // get the move
}