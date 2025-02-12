import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Readfile { 
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Student.txt"))) {
            String line; // Locates the file Student.txt
            while ((line = reader.readLine()) != null) { // Reads one line at a time
                System.out.println(line); // Ensures proper new line handling
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage()); // Catches exceptions and prints an error method
        }
    }
}