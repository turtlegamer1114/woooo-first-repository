import java.util.Random;
import java.util.Scanner;

public class Rockpaperscissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Array for choises
        String[] choices = {"rock", "paper", "scissors"};

        while (true) {
            System.out.println("Enter your choice (rock, paper, or scissors):");
            String playerChoice = scanner.nextLine().toLowerCase();

            // check the players choice
            if (!playerChoiceValid(playerChoice, choices)) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            //random choice for the computer
            int computerChoiceIndex = random.nextInt(choices.length);
            String computerChoice = choices[computerChoiceIndex];

            // Display choices
            System.out.println("You chose: " + playerChoice);
            System.out.println("Computer chose: " + computerChoice);

            // display the winner
            determineWinner(playerChoice, computerChoice);
        }
    }

    // Make sure the choice is valid
    static boolean playerChoiceValid(String playerChoice, String[] choices) {
        for (String validChoice : choices) {
            if (playerChoice.equals(validChoice)) {
                return true;
            }
        }
        return false;
    }

    // determine the winner
    static void determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            System.out.println("Its a tie");
        } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                   (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
            System.out.println("You win");
        } else {
            System.out.println("Computer wins");
        }
    }
}
