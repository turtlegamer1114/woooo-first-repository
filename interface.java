import java.util.ArrayList;
import java.util.Collections;

// base class DinoMaker
class DinoMaker implements Comparable<DinoMaker> {
    // Attributes common to all dinosaurs
    private String name;
    private String type;
    private int size;
    private int speed;
    private int strength;
    private int health;    // New attribute for health
    private String diet;   // New attribute for diet 
    private String habitat; // New attribute for habitat

    // Constructor to initialize name and type
    public DinoMaker(String name, String type) {
        this.name = name;
        this.type = type;
        this.size = 0;
        this.speed = 0;
        this.strength = 0;
        this.health = 100;   // Default health
        this.diet = "Unknown";  // Default diet
        this.habitat = "Unknown"; // Default habitat
    }

    // Constructor to initialize all attributes
    public DinoMaker(String name, String type, int size, int speed, int strength, int health, String diet, String habitat) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.speed = speed;
        this.strength = strength;
        this.health = health;
        this.diet = diet;
        this.habitat = habitat;
    }

    // Default constructor
    public DinoMaker() {
        this.name = "Unknown";
        this.type = "Unknown";
        this.size = 0;
        this.speed = 0;
        this.strength = 0;
        this.health = 100;  // Default health
        this.diet = "Unknown";
        this.habitat = "Unknown";
    }

    // Setting attributes
    public void setSize(int size) {
        this.size = size;
        System.out.println(this.name + " is now size " + size);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        System.out.println(this.name + " is now moving at speed " + speed);
    }

    public void setStrength(int strength) {
        this.strength = strength;
        System.out.println(this.name + " now has strength of " + strength);
    }

    public void setHealth(int health) {
        this.health = health;
        System.out.println(this.name + " now has health points of " + health);
    }

    public void setDiet(String diet) {
        this.diet = diet;
        System.out.println(this.name + " is a " + diet);
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
        System.out.println(this.name + " lives in the " + habitat);
    }

    // Display general information 
    public void displayInfo() {
        System.out.println(this.name + " (" + this.type + ") - Size: " + size + ", Speed: " + speed + ", Strength: " + strength +
                           ", Health: " + health + ", Diet: " + diet + ", Habitat: " + habitat);
    }

    // Method to simulate the dinosaur taking damage
    public void takeDamage(int damage) {
        if (this.health - damage > 0) {
            this.health -= damage;
            System.out.println(this.name + " took " + damage + " damage. Remaining health: " + this.health);
        } else {
            this.health = 0; // Ensure health does not go below 0
            System.out.println(this.name + " took " + damage + " damage and is now defeated.");
        }
    }

    // Implement the compareTo method from the Comparable interface
    @Override
    public int compareTo(DinoMaker other) {
        return Integer.compare(this.size, other.size); // Compare based on size
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        // Create an ArrayList to hold DinoMaker objects
        ArrayList<DinoMaker> dinosaurs = new ArrayList<>();

        // Add 10 DinoMaker objects to the list
        dinosaurs.add(new DinoMaker("Tyrannosaurus", "Carnivore", 40, 25, 30, 100, "Carnivorous", "Forests"));
        dinosaurs.add(new DinoMaker("Triceratops", "Herbivore", 30, 15, 20, 100, "Herbivorous", "Plains"));
        dinosaurs.add(new DinoMaker("Velociraptor", "Carnivore", 15, 40, 15, 100, "Carnivorous", "Deserts"));
        dinosaurs.add(new DinoMaker("Brachiosaurus", "Herbivore", 80, 10, 25, 100, "Herbivorous", "Forests"));
        dinosaurs.add(new DinoMaker("Spinosaurus", "Carnivore", 50, 20, 40, 100, "Carnivorous", "Rivers"));
        dinosaurs.add(new DinoMaker("Stegosaurus", "Herbivore", 25, 12, 20, 100, "Herbivorous", "Plains"));
        dinosaurs.add(new DinoMaker("Ankylosaurus", "Herbivore", 30, 10, 35, 100, "Herbivorous", "Forests"));
        dinosaurs.add(new DinoMaker("Pteranodon", "Carnivore", 20, 60, 10, 100, "Carnivorous", "Coasts"));
        dinosaurs.add(new DinoMaker("Diplodocus", "Herbivore", 60, 15, 15, 100, "Herbivorous", "Forests"));
        dinosaurs.add(new DinoMaker("Allosaurus", "Carnivore", 35, 25, 30, 100, "Carnivorous", "Mountains"));

        // Print unsorted dinosaurs
        System.out.println("Unsorted Dinosaurs:");
        for (DinoMaker dino : dinosaurs) {
            dino.displayInfo();
        }

        // Sort dinosaurs using Collections.sort
        Collections.sort(dinosaurs);

        // Print sorted dinosaurs
        System.out.println("\nSorted Dinosaurs (by Size):");
        for (DinoMaker dino : dinosaurs) {
            dino.displayInfo();
        }
    }
}
