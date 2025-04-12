// THis code was written by Titus Taylor
import java.util.Random;
import java.util.Scanner;

public class DebugGame {
    static boolean debug = true;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        String[] moves = {"rock", "paper", "scissors"};

        if (debug) System.out.println("[DEBUG] Game started");

        while (true) {
            System.out.print("Your move (rock/paper/scissors): ");
            String player = input.nextLine().toLowerCase();

            if (debug) System.out.println("[DEBUG] Player chose: " + player);

            if (!player.equals("rock") && !player.equals("paper") && !player.equals("scissors")) {
                if (debug) System.out.println("[DEBUG] Invalid move");
                System.out.println("Invalid move! Try again.");
                continue;
            }

            String computer = moves[rand.nextInt(3)];
            if (debug) System.out.println("[DEBUG] Computer chose: " + computer);

            System.out.println("Computer chose: " + computer);

            if (player.equals(computer)) {
                System.out.println("Tie!");
            } else if (player.equals("rock") && computer.equals("scissors")) {
                System.out.println("You win!");
            } else if (player.equals("paper") && computer.equals("rock")) {
                System.out.println("You win!");
            } else if (player.equals("scissors") && computer.equals("paper")) {
                System.out.println("You win!");
            } else {
                System.out.println("Computer wins!");
            }
        }
    }
}