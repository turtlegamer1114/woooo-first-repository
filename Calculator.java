import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    public static void main(String[] args) {
        // Create the scanner
        Scanner scanner = new Scanner(System.in);
        
        // Display opening calculator message
        System.out.println("Calculator (Type /help for instructions)");
        
        // create the calculator loop
        while (true) {
            System.out.print("> ");  // Prompt the imputinput, make the design look better
            String input = scanner.nextLine().trim();  // Read user input and remove leading/trailing whitespace
            
            // scan for the /help command
            if (input.equalsIgnoreCase("/help")) {
                showHelp();  // Display information
                continue;   // Skip to next imput
            }
            
            // Check for exit command
            if (input.equalsIgnoreCase("/exit")) {
                System.out.println("Exiting calculator...");
                break;  // Exit the loop and end the program
            }
            
            // Skip empty inputs
            if (input.isEmpty()) {
                continue;
            }
            
            try {
                // Evaluate the expression remove whitespace
                double result = evaluateExpression(input.replaceAll("\\s+", ""));
                
                // Check if result has any decimal places, display error message if there are
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
                
                // Print the result
                System.out.println("= " + longResult);
            } catch (Exception e) {
                // Handle any errors that occur during evaluation
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
        System.out.println("Supported operations are + (addition - (subtraction) x (multipication) / (division)");
        System.out.println("Rules for calculating:");
        System.out.println("1. No decimals");
        System.out.println("2. Maximum 7 digits as a result");
        System.out.println("3. Calculator follows PEMDAS rules");
        System.out.println("Examples of equations:");
        System.out.println("  2x4+3 → 11");
        System.out.println("  10-2/2 → 9");
        System.out.println("calculator Commands:");
        System.out.println("  /help - Show this help message");
        System.out.println("  /exit - Quit the calculator\n");
        System.out.println("Thank you for using the calculator");
    }
    
    // Method to evaluate a mathematical expression using the shunting-yard algorithm
    public static double evaluateExpression(String expression) {
        // Check for empty expression
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("Empty expression");
        }
        
        // Use two stacks: one for numbers and one for operators
        Deque<Double> numbers = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();
        
        // Process each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            // check if character is digit
            if (Character.isDigit(c)) {
                StringBuilder numStr = new StringBuilder();
                // Keep reading digits until somethign isnt a digit
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    numStr.append(expression.charAt(i++));
                }
                i--; 
                numbers.push(Double.parseDouble(numStr.toString()));
            } 
            // check if character is an operator addition, subtraction, multipication for x and X, division
            else if (c == '+' || c == '-' || c == 'x' || c == 'X' || c == '/') {
                // Process operators with higher precedence 
                while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                    numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.push(c);  // Push current operator to a stack
            } else {
                // Invalid character error
                throw new IllegalArgumentException("Invalid character: '" + c + "'");
            }
        }
        
        // Process remaining operators 
        while (!operators.isEmpty()) {
            numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
        }
        
        // Check if one digit is left (the answer) If not throw error
        if (numbers.size() != 1) {
            throw new IllegalArgumentException("Invalid expression format");
        }
        
        return numbers.pop();  // Return result
    }
    
    // determine operator precedence
    private static boolean hasPrecedence(char op1, char op2) {
        // op1 has lower precedence than op2 if:
        // op1 is multiplication/division and op2 is addition/subtraction
        if ((op1 == 'x' || op1 == 'X' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }
    
    // apply an operation
  private static double applyOperation(char operator, double b, double a) {
        switch (operator) {
            case '+': return a + b;  // Addition
            case '-': return a - b;  // Subtraction
            case 'x':
            case 'X': return a * b;  // Multiplication Acepts x X
            case '/':  // Added missing colon here
                if (b == 0) throw new ArithmeticException("Division by zero");
                double result = a / b;
                // Check if division would produce a decimal 
                if (result % 1 != 0) {
                    throw new ArithmeticException("Division would produce decimal");
                }
                return result;
            default: throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}