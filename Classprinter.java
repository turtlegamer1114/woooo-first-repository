import java.util.Scanner;
// This code was written by Titus Taylor
// Class for node
class Bucket {
    String data; // Store data in the bucket
    Bucket next; // look at next node
    Bucket prev; // look at previous node

    // Constructor to initialize the bucket with data
    public Bucket(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

// Main class
public class Classprinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bucket head = null; // Head of the list
        Bucket tail = null; // Tail of the list

        System.out.println("Enter data items. Type 'exit' to stop.");

        while (true) {
            System.out.print("Enter data: ");
            String input = scanner.nextLine();

            // Exit the loop when user types exit (case-insensitive)
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // Create a new bucket with data
            Bucket newBucket = new Bucket(input);

            // If the list is empty new bucket as head and tail
            if (head == null) {
                head = newBucket;
                tail = newBucket;
            } else {
                // Add the bucket at end of the list
                tail.next = newBucket;
                newBucket.prev = tail;
                tail = newBucket;
            }
        }

        // Print the list front to back
        System.out.println("\nPrinting list from front to back:");
        Bucket current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }

        // Print the list  back to front
        System.out.println("\nPrinting list from back to front:");
        current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }

        scanner.close(); // Close scanner
    }
}