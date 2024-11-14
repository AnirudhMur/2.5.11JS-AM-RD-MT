/**
 * Represents the board containing a single heap for the Game of Nim.
 */
public class Board {
    private int count;

    public Board(int initialCount) {
        this.count = initialCount;
        System.out.println("Board initialized with " + initialCount + " objects.");
    }

    public int getCount() {
        return this.count;
    }

    public boolean removeObjects(int count) {
        if (count > this.count || count <= 0) {
            return false;
        }
        this.count -= count;
        return true;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public void display() {
        System.out.println("Current heap count: " + this.count + " objects");
    }
}
