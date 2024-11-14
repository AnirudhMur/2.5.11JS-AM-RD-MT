
//* Entry point for the Game of Nim.
//*/
public class GameRunner {
   public static void main(String[] args) {
       System.out.println("Welcome to the Game of Nim!");

       int initialCount = 15;  // Initial number of objects in the heap
       Game nim = new Game(initialCount);
       nim.play();
   }
}

    

