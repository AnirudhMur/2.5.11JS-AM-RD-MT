import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Manages the gameplay for the Game of Nim.
 */
public class Game {
    private List<Player> players = new ArrayList<>();
    private Player currentPlayer;
    private Board board;

    public Game(int initialCount) {
        this.board = new Board(initialCount);
        setupPlayers();
    }

    public void play() {
        System.out.println("Starting the game!");

        while (!board.isEmpty()) {
            board.display();
            currentPlayer.takeTurn(board);
            switchTurn();
        }

        switchTurn();  // Switch to the winning player
        System.out.println("Game over! " + currentPlayer.getName() + " wins!");
    }

    private void setupPlayers() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name for Player 1: ");
        String player1Name = scanner.nextLine();
        players.add(new Player(player1Name, true));

        System.out.print("Would you like to play against an AI? (yes/no): ");
        String playWithAI = scanner.nextLine().trim().toLowerCase();

        if (playWithAI.equals("yes")) {
            players.add(new Player("AI", false));
        } else {
            System.out.print("Enter name for Player 2: ");
            String player2Name = scanner.nextLine();
            players.add(new Player(player2Name, true));
        }

        currentPlayer = players.get(0); // Set the initial player
    }

    private void switchTurn() {
        currentPlayer = (currentPlayer == players.get(0)) ? players.get(1) : players.get(0);
    }
}
