import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Newstart {
    public static void main(String[] args) {
        // directory
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        //  close the scanner/ writer
        try (Scanner scanner = new Scanner(System.in); 
             FileWriter writer = new FileWriter("output.txt")) {
            
            // Prompt for name (must be "firstname lastname")
            String name = getValidName(scanner);
            writer.write("Name: " + name + "\n");
            System.out.println("Your name is " + name);
            
            // Prompt for zip code
            String zipCode = getValidZipCode(scanner);
            writer.write("Zip Code: " + zipCode + "\n");
            System.out.println("Your zip code is " + zipCode);
            
            // Prompt for pets name
            System.out.println("Enter your pet's name: ");
            String petName = scanner.nextLine();
            writer.write("Pets Name: " + petName + "\n");
            System.out.println("Your pet's name is " + petName);
            
            // Prompt for  age
            int age = getValidAge(scanner);
            writer.write("Age: " + age + "\n");
            System.out.println("Your age is " + age);
            
            // Prompt for and  phone number
            String phoneNumber = getValidPhoneNumber(scanner);
            writer.write("Phone Number: " + phoneNumber + "\n");
            System.out.println("Your phone number is " + phoneNumber);
            
            // Prompt for email
            System.out.println("Enter your email: ");
            String email = scanner.nextLine();
            writer.write("Email: " + email + "\n");
            System.out.println("Your email is " + email);
            
            // Determine age message
            String ageComparisonMessage;
            if (age > 30) {
                ageComparisonMessage = "You are older than 50% of the population.";
            } else {
                ageComparisonMessage = "You are younger than 50% of the population.";
            }
            
            // Write age comparison message 
            writer.write("Age Comparison: " + ageComparisonMessage + "\n"); // Write
            System.out.println(ageComparisonMessage); // Print 
            
            //good message message
            System.out.println("Data has been written to output.txt");
        } catch (IOException e) {
            // Handle errors
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    //  validate name (must be "firstname lastname")
    private static String getValidName(Scanner scanner) {
        while (true) {
            System.out.println("Enter your name (firstname lastname): ");
            String name = scanner.nextLine().trim(); // Remove leading/trailing spaces
            if (name.matches("[A-Za-z]+\\s[A-Za-z]+")) { // Check if it's two words separated by a space
                return name;
            } else {
                System.out.println("Invalid name format. Please enter your name as 'firstname lastname'.");
            }
        }
    }

    //validate zip code (must be 5 digits)
    private static String getValidZipCode(Scanner scanner) {
        while (true) {
            System.out.println("Enter your zip code (5 digits): ");
            String zipCode = scanner.nextLine();
            if (zipCode.matches("\\d{5}")) { // Check if it's exactly 5 digits
                return zipCode;
            } else {
                System.out.println("Invalid zip code. Please enter a 5-digit number.");
            }
        }
    }

    // validate age (no negatives)
    private static int getValidAge(Scanner scanner) {
        while (true) {
            System.out.println("Enter your age: ");
            String input = scanner.nextLine();
            try {
                int age = Integer.parseInt(input);
                if (age > 0) { // Check if age is a positive number
                    return age;
                } else {
                    System.out.println("Invalid age. Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("This input is not an integer. Please try again!");
            }
        }
    }

    //validate phone number 
    private static String getValidPhoneNumber(Scanner scanner) {
        while (true) {
            System.out.println("Enter your phone number (10 digits): ");
            String phoneNumber = scanner.nextLine();
            if (phoneNumber.matches("\\d{10}")) { // Check if the nubmers 10 digit
                return phoneNumber;
            } else {
                System.out.println("Invalid phone number. Please enter a 10-digit number.");
            }
        }
    }
}