// Deck Class
// Made By: Henry Smith
// Started: 11/12/2024
// Finished: 12/20/2024

import java.util.ArrayList;
import java.util.List;

public class NDeckClass  { // Holds every card in a 52 US Deck in Java objects

    public List<NCardClass> fillTheDeck() {
    //public static void main(String[] args) {

    List<NCardClass> Deck = new ArrayList<>(); 

    // All Heart Cards
    Deck.add(new NCardClass("♥︎", "2", 2));
    Deck.add(new NCardClass("♥︎", "3", 3));
    Deck.add(new NCardClass("♥︎", "4", 4));
    Deck.add(new NCardClass("♥︎", "5", 5));
    Deck.add(new NCardClass("♥︎", "6", 6));
    Deck.add(new NCardClass("♥︎", "7", 7));
    Deck.add(new NCardClass("♥︎", "8",8));
    Deck.add(new NCardClass("♥︎", "9", 9));
    Deck.add(new NCardClass("♥︎", "10", 10));
    Deck.add(new NCardClass("♥︎", "Q", 11));
    Deck.add(new NCardClass("♥︎", "K", 12));
    Deck.add(new NCardClass("♥︎", "A", 1));

        // All Club Cards
        Deck.add(new NCardClass("♣︎", "2", 2));
        Deck.add(new NCardClass("♣︎", "3", 3));
        Deck.add(new NCardClass("♣︎", "4", 4));
        Deck.add(new NCardClass("♣︎", "5", 5));
        Deck.add(new NCardClass("♣︎", "6", 6));
        Deck.add(new NCardClass("♣︎", "7", 7));
        Deck.add(new NCardClass("♣︎", "8",8));
        Deck.add(new NCardClass("♣︎", "9", 9));
        Deck.add(new NCardClass("♣︎", "10", 10));
        Deck.add(new NCardClass("♣︎", "Q", 11));
        Deck.add(new NCardClass("♣︎", "K", 12));
        Deck.add(new NCardClass("♣︎", "A", 1));


            // All Diamond Cards
            Deck.add(new NCardClass("♦︎", "2", 2));
            Deck.add(new NCardClass("♦︎", "3", 3));
            Deck.add(new NCardClass("♦︎", "4", 4));
            Deck.add(new NCardClass("♦︎", "5", 5));
            Deck.add(new NCardClass("♦︎", "6", 6));
            Deck.add(new NCardClass("♦︎", "7", 7));
            Deck.add(new NCardClass("♦︎", "8",8));
            Deck.add(new NCardClass("♦︎", "9", 9));
            Deck.add(new NCardClass("♦︎", "10", 10));
            Deck.add(new NCardClass("♦︎", "Q", 11));
            Deck.add(new NCardClass("♦︎", "K", 12));
            Deck.add(new NCardClass("♦︎", "A", 1));

                // All Spade Cards
                Deck.add(new NCardClass("♣︎", "2", 2));
                Deck.add(new NCardClass("♣︎", "3", 3));
                Deck.add(new NCardClass("♣︎", "4", 4));
                Deck.add(new NCardClass("♣︎", "5", 5));
                Deck.add(new NCardClass("♣︎", "6", 6));
                Deck.add(new NCardClass("♣︎", "7", 7));
                Deck.add(new NCardClass("♣︎", "8",8));
                Deck.add(new NCardClass("♣︎", "9", 9));
                Deck.add(new NCardClass("♣︎", "10", 10));
                Deck.add(new NCardClass("♣︎", "Q", 11));
                Deck.add(new NCardClass("♣︎", "K", 12));
                Deck.add(new NCardClass("♣︎", "A", 1));

                return Deck;
    }
}




    

    



       
   


