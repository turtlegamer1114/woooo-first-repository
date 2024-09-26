public class Horse {

    String name;
    int birthYear;

    // Constructor
    public Horse(String horseName, int year) {
        name = horseName;
        birthYear = year;
    }

    // Overriding the toString method
    @Override
    public String toString() {
        return name + ", Age: " + (2024 - birthYear); // Assuming the current year is 2024
    }

    // Change the horses name.
    public void changeName(String newName) {
        name = newName;
    }

    public static void main(String[] args) {
        // Create three Horses as objects
        Horse horse1 = new Horse("Spirit", 2015);
        Horse horse2 = new Horse("Jimmy", 2004);
        Horse horse3 = new Horse("Benjamin", 2021);

        // Print each horse
        System.out.println(horse1);
        System.out.println(horse2);
        System.out.println(horse3);
    }
}