import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main { 
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("student.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) { // Reads one line at a time
                System.out.println(line); // Ensures proper new line handling
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

