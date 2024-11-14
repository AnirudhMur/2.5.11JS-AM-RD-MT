import java.util.Scanner;

/**
 * Represents a player in the Game of Nim, either human or AI.
 */
public class Player {
    private String name;
    private boolean isHuman;

    public Player(String name, boolean isHuman) {
        this.name = name;
        this.isHuman = isHuman;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Determines the number of objects the AI should remove to guarantee a win.
     * @param board The game board containing the heap.
     * @return The count of objects to remove to reach a winning position.
     */
    private int calculateWinningMove(Board board) {
        int count = board.getCount();
        
        // Calculate the nearest power of 2 minus 1 (1, 3, 7, 15, etc.) below the current count
        int target = 1;
        while ((target * 2) - 1 < count) {
            target = (target * 2) - 1;
        }

        int move = count - target;

        // Ensure move is valid and at least 1
        if (move <= 0 || move > count) {
            move = 1;
        }

        System.out.println("AI calculated move: " + move);
        return move;
    }

    /**
     * Method for player to take a turn. If AI, it uses a winning strategy;
     * if human, prompts for input.
     * @param board The game board containing the heap.
     * @return True if the turn is valid; false if invalid (retries turn).
     */
    public boolean takeTurn(Board board) {
        System.out.println(this.name + "'s turn.");
        
        int count;
        if (this.isHuman) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose the number of objects to remove: ");
            count = scanner.nextInt();
        } else {
            // Calculate the optimal move for AI
            count = calculateWinningMove(board);
            System.out.println("AI removes " + count + " objects.");
        }

        if (!board.removeObjects(count)) {
            System.out.println("Invalid move. Try again.");
            return takeTurn(board); // retry turn if move was invalid
        }
        return true;
    }
}
