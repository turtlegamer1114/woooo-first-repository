// This code was written by Titus Taylor
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    
    // Main method 
    public static void main(String[] args) {
        // Create scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // Display opening calculator message
        System.out.println("Calculator (Type /help for instructions)");
        
        // Main loop
        while (true) {
            // Display the prompt to insert info
            System.out.print("> ");
            // Read/trim user input
            String input = scanner.nextLine().trim();
            
            // Check for help command
            if (input.equalsIgnoreCase("/help")) {
                showHelp();  // Display help information
                continue;     // Skip to next iteration
            }
            
            // Check for exit command
            if (input.equalsIgnoreCase("/exit")) {
                System.out.println("Exiting calculator...");
                break;  // Exit the loop and end program
            }
            
            // Skip empty inputs
            if (input.isEmpty()) {
                continue;
            }
            
            try {
                // Evaluate expression (remove whitespace)
                double result = evaluateExpression(input.replaceAll("\\s+", ""));
                
                // Check if result has any decimal places
                if (result % 1 != 0) {
                    throw new ArithmeticException("Decimal results not allowed");
                }
                
                // Convert to long
                long longResult = (long) result;
                String resultStr = Long.toString(longResult);
                
                // Check if result exceeds 7-digit limit
                if (resultStr.length() > 7) {
                    throw new ArithmeticException("Result exceeds 7-digit limit");
                }
                
                // Display result
                System.out.println("= " + longResult);
            } catch (Exception e) {
                // Handle errors that occur during evaluation
                System.out.println("Error: " + e.getMessage());
            }
        }
        
        // Close the scanner before exiting
        scanner.close();
    }
    
    // Method to display help information
    private static void showHelp() {
        System.out.println("\nCalculator Help:");
        System.out.println("Enter calculations");
        System.out.println("Supported operations: + - x / ^ !");
        System.out.println("Rules:");
        System.out.println("1. No decimals allowed in input or output");
        System.out.println("2. Maximum 7-digit results");
        System.out.println("3. Follows PEMDAS order of operations (Parentheses, Exponents, Multiply/Divide, Add/Subtract)");
        System.out.println("4. Factorials (!) must be positive integers ≤ 10");
        System.out.println("5. Factorials and exponents can be used anywhere in the equation");
        System.out.println("Examples:");
        System.out.println("  2x4+3 >11 (multiplication before addition)");
        System.out.println("  10-2/2 >9 (division before subtraction)");
        System.out.println("  5! >120 (factorial of 5)");
        System.out.println("  3^4 >81 (3 to the power of 4)");
        System.out.println("  2 + 3! >8 (factorial in middle of expression)");
        System.out.println("  2^3 * 4 >32 (exponent in middle of expression)");
        System.out.println("Commands:");
        System.out.println("  /help - Display this help message");
        System.out.println("  /exit - Quit the calculator\n");
    }
    
    // Main expression evaluation method
    public static double evaluateExpression(String expression) {
        // Check for empty input
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("Empty expression");
        }
        
        // Stack numbers/operands
        Deque<Double> numbers = new ArrayDeque<>();
        // Stack operators
        Deque<Character> operators = new ArrayDeque<>();
        
        // Process characters in the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // check if character is a digit
            if (Character.isDigit(c)) {
                StringBuilder numStr = new StringBuilder();
                // Read all digits
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    numStr.append(expression.charAt(i++));
                }
                i--; // Adjust index 
                
                // Push number to stack
                numbers.push(Double.parseDouble(numStr.toString()));
            } 
            // Handle opening parenthesis
            else if (c == '(') {
                operators.push(c);
            }
            // Handle closing parenthesis
            else if (c == ')') {
                // Process all operators 
                while (!operators.isEmpty() && operators.peek() != '(') {
                    processOperation(numbers, operators);
                }
               
                operators.pop(); // Remove the '(' from stack
            }
            // Handle factorial operator
            else if (c == '!') {
                // Factorial is a unary operator - just process it immediately
                if (numbers.isEmpty()) {
                    throw new IllegalArgumentException("Factorial requires a number");
                }
                double num = numbers.pop();
                // Validate factorial 
                if (num < 0 || num % 1 != 0) throw new IllegalArgumentException("Factorial must be positive integer");
                if (num > 10) throw new IllegalArgumentException("Factorial > 10");
                // Calculate factorial and push to stack
                numbers.push((double) factorial((long)num));
            }
            // Handle other operators
            else if (isOperator(c)) {
                // Process operators with higher or equal precedence
                while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
                    processOperation(numbers, operators);
                }
                // Push current operator to stack
                operators.push(c);
            }
            else {
                // Invalid character encountered error
                throw new IllegalArgumentException("Invalid character: '" + c + "'");
            }
        }
        
        // Process any remaining operators
        while (!operators.isEmpty()) {
            processOperation(numbers, operators);
        }
        
        // Final result should be one number
        if (numbers.size() != 1) {
            throw new IllegalArgumentException("Invalid expression");
        }
        
        // Return the final result
        return numbers.pop();
    }
    
    // Helper method to process an operation
    private static void processOperation(Deque<Double> numbers, Deque<Character> operators) {
        char op = operators.pop();
        if (op == '!') {
            // Factorial is handled separately in the main loop
            throw new IllegalArgumentException("Unexpected factorial operator");
        } else {
            if (numbers.size() < 2) {
                throw new IllegalArgumentException("Not enough operands for operator " + op);
            }
            double b = numbers.pop();
            double a = numbers.pop();
            numbers.push(applyOp(op, b, a));
        }
    }
    
    // Check if a character is a supported operator (excluding factorial)
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == 'x' || c == 'X' || c == '/' || c == '^';
    }
    
    // Define operator precedence a higher number means higher precedence
    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;  // Lowest precedence
            case 'x':
            case 'X':
            case '/':
                return 2;  // Medium precedence
            case '^':
                return 3;  // Higher precedence
            case '!':
                return 4;  // Highest precedence (factorial)
            default:
                return 0;  // For parentheses
        }
    }
    
    // Apply an operation to two operands
    private static double applyOp(char op, double b, double a) {
        switch (op) {
            case '+': 
                return a + b;  // Addition
            case '-': 
                return a - b;  // Subtraction
            case 'x':
            case 'X': 
                return a * b;  // Multiplication (accepts both x and X)
            case '/': 
                // Check division by zero
                if (b == 0) throw new ArithmeticException("Division by zero");
                double result = a / b;
                // Check for decimals
                if (result % 1 != 0) throw new ArithmeticException("Decimal result");
                return result;
            case '^': 
                // Check for negative exponents
                if (b < 0) throw new ArithmeticException("Negative exponent");
                return Math.pow(a, b); 
            default: 
                throw new IllegalArgumentException("Unknown operator");
        }
    }
    
    // Calculate factorial 
    private static long factorial(long n) {
        // Factorial of 0 is 1 (makes them easier)
        if (n == 0) return 1;
        long result = 1;
        // Multiply all numbers from 1 to n
        for (long i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    } 
}