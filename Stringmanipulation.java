// This is a String manipulation project created by Titus Taylor
import java.util.Scanner;    

public class Stringmanipulation {
    public static void main(String[] args) {
        String s = "The quick brown fox jumped over the lazy small dog ";
        String[] words = s.split("\\W+"); // Split no word characters
        
        int wordCount = 0; // create the word counter
        for (String word : words) {
            System.out.println(word);
            wordCount++;
        }
        
        System.out.println("number of words: " + wordCount);
        Scanner scanner = new Scanner(System.in); // Create scanner
       
        System.out.print("Enter your string: "); // Create a string imput
        String inputString = scanner.nextLine();
        words = inputString.split("\\W+");
         wordCount = 0; // create the word counter
        for (String word : words) {
            System.out.println(word);
            wordCount++;
        }
        System.out.println("number of words: " + wordCount); // Print string wordcount
    
    
    }
}
