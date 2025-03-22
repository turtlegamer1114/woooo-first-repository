// This code was written by Titus Taylor
import java.util.InputMismatchException;
import java.util.Scanner;

// Nodeclass 
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

//Stack implementation
class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    // Push 
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // create pop
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    // Check stack
    public boolean isEmpty() {
        return top == null;
    }

    // Print stack
    public void printStack() {
        Node current = top;
        System.out.print("Stack Front to back0: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("None");
    }
}

// Queue implimentor
class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        this.front = this.rear = null;
    }

    // queue operation
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // remove operatipn
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return -1;
        }
        int dequeuedData = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return dequeuedData;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Print contents
    public void printQueue() {
        Node current = front;
        System.out.print("Queue (Front to back): ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("None");
    }
}

// create class
public class Nodemaker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        Queue queue = new Queue();

        // put data into stack and queue
        System.out.println("Enter integers. Enter -1 to stop.");
        while (true) {
            try {
                System.out.print("Enter number: ");
                int input = scanner.nextInt();
                if (input == -1) {
                    break;
                }
                stack.push(input);
                queue.enqueue(input);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clears the invalid input
            }
        }

        // Print  contents
        System.out.println("\nContents of stack:");
        stack.printStack();
        queue.printQueue();

        // Create selection screen
        System.out.println("\nSelection screen");
        System.out.println("Type 'back' to go to the previous page or 'exit' to quit.");
        scanner.nextLine(); 
        while (!stack.isEmpty()) {
            System.out.print("Current selection: " + stack.pop() + "\nCommand: ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("exit")) {
                break;
            } else if (!command.equalsIgnoreCase("back")) {
                System.out.println("Invalid command. Type 'back' or 'exit'.");
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Cant go back");
        }

        scanner.close();
    }
}