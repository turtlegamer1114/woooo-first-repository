// Titus Taylor made this Project for His BrainTree Java course.
public class OddEvenArraySum {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        int sum = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.println(number + " is even");
            } else {
                System.out.println(number + " is odd");
            }
            sum += number;
        }
        System.out.println("Sum of all numbers: " + sum);
    }
}