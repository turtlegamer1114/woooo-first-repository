// This is a String manipulation project created by Titus Taylor
public class Main {
    public static void main(String[] args) {
        String s = "The quick brown fox jumped over the lazy dog ";
        String[] words = s.split("\\W+"); // Split nno word characters
        
        int wordCount = 0; // create the word counter
        for (String word : words) {
            System.out.println(word);
            wordCount++;
        }
        
        System.out.println("number of words: " + wordCount);
    }
}
