public class Debuggableprogram {
    // Debug toggle - set to true to enable debug messages
    private static final boolean DEBUG = true;

    public static void main(String[] args) {
        int number = 5;
        debugPrint("Starting factorial calculation for number: " + number);
        
        long result = calculateFactorial(number);
        
        debugPrint("Calculation done. Result: " + result);
        System.out.println("The factorial of " + number + " is: " + result);
    }

    public static long calculateFactorial(int n) {
        debugPrint("Entering calculateFactorial with n = " + n);
        
        if (n < 0) {
            debugPrint("Negative input detected");
            throw new IllegalArgumentException("Factorial cannot be a negative number");
        }
        
        if (n == 0 || n == 1) {
            debugPrint(" returning 1");
            return 1;
        }
        
        long factorial = n * calculateFactorial(n - 1);
        debugPrint("Intermediate result for n = " + n + ": " + factorial);
        
        return factorial;
    }

    private static void debugPrint(String message) {
        if (DEBUG) {
            System.out.println("[DEBUG] " + message);
        }
    }
}