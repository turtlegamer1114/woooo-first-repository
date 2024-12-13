import java.util.*;

public class CardGame {

    // Constant for all the cards
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private static final int NUM_CARDS = 52;
    
    // Card classes
    static class Card {
        String suit;
        String rank;
        int value; // Numeric value for comparing
        
        Card(String suit, String rank, int value) {
            this.suit = suit;
            this.rank = rank;
            this.value = value;
        }

        @Override
        public String toString() {
            return rank + " of " + suit;
        }
    }

    public static void main(String[] args) {
        // Create a deck of cards
        Card[] deck = createDeck();
        shuffleDeck(deck);

        // Deal two hands of 5 cards each
        Card[] hand1 = dealHand(deck, 0);
        Card[] hand2 = dealHand(deck, 5);

        // Display the hands
        System.out.println("Hand 1:");
        displayHand(hand1);
        System.out.println("\nHand 2:");
        displayHand(hand2);

        // Deciding the winner
        int hand1Score = calculateHandScore(hand1);
        int hand2Score = calculateHandScore(hand2);

        System.out.println("\nHand 1 Score: " + hand1Score);
        System.out.println("Hand 2 Score: " + hand2Score);

        // Determine/display the winner
        if (hand1Score > hand2Score) {
            System.out.println("\nHand 1 wins!");
        } else if (hand2Score > hand1Score) {
            System.out.println("\nHand 2 wins!");
        } else {
            System.out.println("\nIt's a tie!");
        }
    }

    // Create/return a deck of 52 cards
    private static Card[] createDeck() {
        Card[] deck = new Card[NUM_CARDS];
        int index = 0;

        // Fill the deck
        for (String suit : SUITS) {
            for (int i = 0; i < RANKS.length; i++) {
                String rank = RANKS[i];
                int value = i + 2; // Value for comparing
                deck[index++] = new Card(suit, rank, value);
            }
        }

        return deck;
    }

    // Shuffling
    private static void shuffleDeck(Card[] deck) {
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int j = random.nextInt(deck.length);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    // Deal a hand
    private static Card[] dealHand(Card[] deck, int startIndex) {
        Card[] hand = new Card[5];
        System.arraycopy(deck, startIndex, hand, 0, 5);
        return hand;
    }

    // Display the hand
    private static void displayHand(Card[] hand) {
        for (Card card : hand) {
            System.out.println(card);
        }
    }

    // Calculate the score
    private static int calculateHandScore(Card[] hand) {
        int score = 0;
        for (Card card : hand) {
            score += card.value;
        }
        return score;
    }
}
