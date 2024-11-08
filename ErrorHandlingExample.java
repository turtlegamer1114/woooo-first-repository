public class ErrorHandlingExample {
    public static void main(String[] args) {
        // Array with an error to cause the esception
        int[] numbers = {1, 2, 3};

        try {
            // This will cause an exception because the array has only 3 elements (index 0-2)
            System.out.println("Trying to access an element beyond the array bounds...");
            System.out.println("Element at index 5: " + numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Tried to access an index that doesn't exist in the array.");
            System.out.println("Explanation: Arrays in Java have a fixed size, and you tried to access an index outside of the array's size.");
        }

        // Division by zero to cause ArithmeticException
        try {
            // This will cause an ArithmeticException because dividing by zero is not allowed in this program
            System.out.println("\nPerforming a division by zero...");
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
            System.out.println("Explanation: You can't divide a number by zero, as it leads to an undefined result.");
        }

        // Continue on to show that the program catches errors and continues on
        System.out.println("\nProgram successfully handled the errors and closed without crashing.");
    }
}
