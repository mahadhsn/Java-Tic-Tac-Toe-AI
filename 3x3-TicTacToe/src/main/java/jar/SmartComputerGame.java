package jar;

// SmartComputerGame class that extends Game class | runs the game with two human players
public class SmartComputerGame extends Game {
    
    public SmartComputerGame (Board board, Player player1, Player player2) { // constructor
        super(new BasicBoard(), player1, player2);
    }

    // main method to run the game
    public static void main(String[] args) {
        Player player1 = new HumanPlayer('X');
        Player player2 = new SmartComputerPlayer('O', 'X');
        Game game = new SmartComputerGame(new BasicBoard(), player1, player2);
        game.run();
    }
}