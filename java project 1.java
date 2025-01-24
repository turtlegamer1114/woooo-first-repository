// write to a file in Java
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteStudentFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt the user imput
            System.out.print("Enter your full name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your school year: ");
            String year = scanner.nextLine();

            System.out.print("Enter the name of your school: ");
            String school = scanner.nextLine();

            // Write the input to a file named 'student.txt'
            FileWriter writer = new FileWriter("student.txt");
            writer.write(name + "\n");
            writer.write(year + "\n");
            writer.write(school + "\n");
            writer.close();

            System.out.println("Details have been saved to 'student.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }    
}
