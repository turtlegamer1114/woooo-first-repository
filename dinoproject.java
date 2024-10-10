// Define the base class DinoMaker
class DinoMaker {
    // Attributes common to all dinosaurs (or any subclass like dino)
    private String name;
    private String type;
    private int size;
    private int speed;
    private int strength;

    // initialize name and type
    public DinoMaker(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // set the size of the dinosaur
    public void size(int size) {
        this.size = size;
        System.out.println(this.name + " is now size " + size);
    }

    // set the speed of the dinosaur
    public void speed(int speed) {
        this.speed = speed;
        System.out.println(this.name + " is now moving at speed " + speed);
    }

    // set the strength of the dinosaur
    public void strength(int strength) {
        this.strength = strength;
        System.out.println(this.name + " now has strength of " + strength);
    }

    // Display general information about the dinosaur
    public void displayInfo() {
        System.out.println(this.name + " (" + this.type + ") - Size: " + size + ", Speed: " + speed + ", Strength: " + strength);
    }
}

// Define the dino class which extends DinoMaker
class dino extends DinoMaker {
    // Constructor to initialize a dinosaur object
    public dino(String name, String type) {
        super(name, type);  // Pass the name and type to the superclass (DinoMaker)
    }
}

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        // Create a new dino object
        dino mydino = new dino("Dinosaur", "Tyrannosaurus Rex");

        // Set attributes for the dinosaur
        mydino.size(30);        // sets size to 30
        mydino.speed(10);       // sets speed to 10
        mydino.speed(25);       // changes speed to 25
        mydino.strength(50);    // sets strength to 50

        // Display the state of the dinosaur
        mydino.displayInfo();
        
        // To create more objects
        dino anotherDino = new dino("Dino2", "Velociraptor");
        anotherDino.size(20);
        anotherDino.speed(15);
        anotherDino.strength(40);
        anotherDino.displayInfo();
    }
}