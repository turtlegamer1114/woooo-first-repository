import java.io.*; // For handling file input/output operations
import java.util.*; // For utility classes like ArrayList

public class Probability {
    public static void main(String[] args) {
        // File path of the input CSV file
        String fileName = "/uploads/_letter_frequency.csv";

        // Lists to store the information
        List<String> letters = new ArrayList<>();
        List<Integer> frequencies = new ArrayList<>();
        List<Float> percentages = new ArrayList<>();

        // Reading the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Skip the header line in the CSV file
            br.readLine();

            // Read each line from the file
            while ((line = br.readLine()) != null) {
                // Remove any double quotes and trim whitespace
                line = line.replaceAll("\"", "").trim();

                // Split the line into columns based on commas
                String[] tokens = line.split(", \\s*");

                // Validate that the line has 3 columns
                if (tokens.length == 3) {
                    // Add data to respective lists after trimming
                    letters.add(tokens[0].trim());
                    frequencies.add(Integer.parseInt(tokens[1].trim()));
                    percentages.add(Float.parseFloat(tokens[2].trim()));
                } else {
                    // Print a message for invalid or improperly formatted lines
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            // Handle errors
            System.out.println("Error reading the file: " + e.getMessage());
            return; // Exit if there's an error
        }

        // Display letter frequencies and percentages
        System.out.println("Letter\tFrequency\tPercentage");
        for (int i = 0; i < letters.size(); i++) {
            // Print each letter with its corresponding frequency and percentage
            System.out.printf("%s\t%d\t%.1f%%\n", letters.get(i), frequencies.get(i), percentages.get(i));
        }

        // Calculate total frequency and percentage
        int totalFrequency = 0; // Variable to store the sum of all frequencies
        float totalPercentage = 0; // Variable to store the sum of all percentages

        // add up all the frequencies
        for (int frequency : frequencies) {
            totalFrequency += frequency;
        }

        // add all the percentages
        for (float percentage : percentages) {
            totalPercentage += percentage;
        }

        // Calculate the frequency
        double averageFrequency = (double) totalFrequency / letters.size();

        // Print the total/average values
        System.out.println("Total\t" + Math.round(averageFrequency) + "\t" + String.format("%.1f%%", totalPercentage));
    }
}