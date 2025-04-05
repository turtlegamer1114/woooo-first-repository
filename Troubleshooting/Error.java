/*
Error filled file created by
Kimg@techtrepacademy.com
for my java class to learn troubleshooting on
*/
public class Error {
    // Debug: Added main method - Java programs need a main method as entry point
    public static void main(String[] args) {
        // These statements were outside any method - moved inside main
        System.out.println("hello everybody");
        System.out.println("am I doing this correctly");
        
        // Debug: Fixed typo in println (was printlm)
        for (int i=0; i<10; i++) {
            System.out.println("the number i is "+i);
        }

        // Debug: Multiple errors in this line:
        // 1. 'For' should be 'for' (Java is case-sensitive)
        // 2. 'Int' should be 'int' (primitive types are lowercase)
        // 3. ':' should be ';' in for loop syntax
        // 4. Wrong condition (i>10 would exit immediately)
        // Original incorrect line:
        // For (Int i=0:i>10;i++){
        for (int i=0; i<10; i++) {
            System.out.println("the new number i is "+i);
        }
        
        // Debug: 'i' was out of scope here - it only exists within the for loops
        // Need to declare a new variable or reuse an existing one
        int i = 0;  // Declaring i for this scope
    
        //  system should be System 
        if (i == 0) {
            System.out.print("i is equal to zero");
        } else {
            System.out.print("i is not equal to zero");
        }
        
        // Add missing brace
    }
}