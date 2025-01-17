
import java.util.Scanner;

public class InputReading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Asking for first name
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        // Asking for last name
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        // Outputting the greeting
        System.out.println("Hello " + firstName + ", can I call you Mr " + lastName + "?");
    }
}