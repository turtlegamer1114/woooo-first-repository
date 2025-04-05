/*
Error filled file created by
Kimg@techtrepacademy.com
for my java class to learn troubleshooting on
*/
// This code was fixed by Titus Taylor
public class Error {
    //  Add method
    public static void main(String[] args) {
        // move inside class
        System.out.println("hello everybody");
        System.out.println("am I doing this correctly");
        
        // Debug: Fixed typo in println (was printlm)
        for (int i=0; i<10; i++) {
            System.out.println("the number i is "+i);
        }

        // For should be for, Int should be int convert colon to semi colon fix condition
        for (int i=0; i<10; i++) {
            System.out.println("the new number i is "+i);
        }
        
        // declare the variable
        int i = 0;  // declare i
        //  system should be System 
        if (i == 0) {
            System.out.print("i is equal to zero");
        } else {
            System.out.print("i is not equal to zero");
        }
        
        // Add missing brace
    }
}