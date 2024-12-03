package jar;

// Restart interface
public interface Restart {

    boolean checkRestart(int[] move); // check if the move is to restart the game

    Player restart(Player currentPlayer); // restart the game

}