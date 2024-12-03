package jar;

// Abstract Game class without any modifications
public abstract class Game implements Restart {
    protected Board board; // board
    protected Player player1; // player 1
    protected Player player2; // player 2

    public Game(Board board, Player player1, Player player2) { // constructor
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public boolean checkRestart(int[] move) { // check if the move is to restart the game
        return move[0] == -1 && move[1] == -1;
    }

    @Override
    public Player restart(Player currentPlayer) { // restart the game
        board.clearBoard();
        System.out.println("Game restarted.");
        System.out.println();
        return player1;
    }

    public void run() { // run the game
        Player currentPlayer = player1;

        while (true) {
            board.showBoard(); // show the board
            System.out.println("Player " + currentPlayer.getSymbol() + "'s turn."); // prompt the user
            System.out.println();

            int[] move = currentPlayer.getMove(board); // get the move

            if (checkRestart(move)) { // if the move is to restart the game
                currentPlayer = restart(currentPlayer);
                continue;
            }

            if (!board.placeMove(move[0], move[1], currentPlayer.getSymbol())) { // place the move
                System.out.println("Invalid move. Try again."); 
                continue; // Retry
            }

            int gameState = board.endGame(currentPlayer.getSymbol());
            if (gameState == 1) { // check if the player has won
                board.showBoard();
                System.out.println("Player " + currentPlayer.getSymbol() + " wins!"); // print the winner
                break;
            }
            else if (gameState == 2) { // check if the player has won
                board.showBoard();
                System.out.println("Player " + currentPlayer.getSymbol() + " wins!"); // print the winner
                break;
            }
            else if (board.isFull()) { // check if the board is full
                board.showBoard();
                System.out.println("It's a draw!"); // print the draw
                break;
            }
            else {
                currentPlayer = currentPlayer == player1 ? player2 : player1; // switch players
            }
        }
    }
}