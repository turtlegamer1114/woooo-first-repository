// Card Game Class Version 2.5
// Made By: Henry Smith
// Started: 3/4/2025
// Finished: 3/7/2025
// Updated: 3/12/2025

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class NGameClass {   

    public static String suit;
    public static String number;
    public static int value; 
    public static int playerCount;
    public static int FRules;
    public static int roundCount;

// 1: The starting point of the code 
    public static void main(String[] args) {

// 2: Creates variables for the class
        int sPlayer1sum = 0;
        int sPlayer2sum = 0;
        int sPlayer3sum = 0;
        int sPlayer4sum = 0;
        int sPlayer5sum = 0;
        int Player1sum = 0;
        int Player2sum = 0;
        int Player3sum = 0;
        int Player4sum = 0;
        int Player5sum = 0;
        int player1Com = 0;
        int player2Com = 0;
        int player3Com = 0;
        int player4Com = 0;
        int player5Com = 0;
        int randomizer = 0;
        int NCardi = 15;
        int OCardi = 16;
        

// 3: Creates a deck, and fills it with the DeckClass
        System.out.println(" "); 
        System.out.println("Downloading Deck from [NDeckClass]..."); 
        System.out.println(" "); 
        NDeckClass TheDeck = new NDeckClass();
        List<NCardClass> Deck = TheDeck.fillTheDeck();
        System.out.println("Deck is Ready"); 
        System.out.println(" "); 


// 4: Makes an extra copy of the deck for shuffling (probably isn't nessacery but rather safe than sorry ;) )
        List<NCardClass> NewDeck = new ArrayList<>();
        NewDeck.addAll(Deck);
        Collections.shuffle(NewDeck);
        Scanner UserI = new Scanner(System.in);
        Random randomC = new Random();


// 5: Creates new lists for each player, and fills that list with 7 cards from the shuffled deck
        List<NCardClass> Player1 = new ArrayList<>();{
            Player1.addAll(NewDeck.subList(0 ,2));
        }
        List<NCardClass> Player2 = new ArrayList<>();{
            Player2.addAll(NewDeck.subList(3 ,5));
        }
        List<NCardClass> Player3 = new ArrayList<>();{
            Player3.addAll(NewDeck.subList(6 ,8));
        }
        List<NCardClass> Player4 = new ArrayList<>();{
            Player4.addAll(NewDeck.subList(9 ,11));
        }
        List<NCardClass> Player5 = new ArrayList<>();{
            Player5.addAll(NewDeck.subList(12 ,14));
        }
        List<NCardClass> RCPlayer1 = new ArrayList<>();{
            RCPlayer1.addAll(NewDeck.subList(1 ,2));
        }
        List<NCardClass> RCPlayer2 = new ArrayList<>();{
            RCPlayer2.addAll(NewDeck.subList(4 ,5));
        }
        List<NCardClass> RCPlayer3 = new ArrayList<>();{
            RCPlayer3.addAll(NewDeck.subList(7 ,8));
        }
        List<NCardClass> RCPlayer4 = new ArrayList<>();{
            RCPlayer4.addAll(NewDeck.subList(10 ,11));
        }
        List<NCardClass> RCPlayer5 = new ArrayList<>();{
            RCPlayer5.addAll(NewDeck.subList(13 ,14));
        }
        System.out.println(" ");
        System.out.println("Please insert player count (1 through 5)"); 
        if (UserI.hasNextInt()) {
            playerCount = UserI.nextInt();
            if (playerCount >=0 && playerCount <=5){
            } else {                
            System.out.println("Incorrect Input! Please enter a number 1 through 5!");
            }
        }
        System.out.println(" ");
        System.out.println("Please insert the amount of rounds you would like to play for (1 through 3)"); 
        if (UserI.hasNextInt()) {
            roundCount = UserI.nextInt();
            if (roundCount >=0 && roundCount <=3){
            } else {                
            System.out.println("Incorrect Input! Please enter a number 1 through 3!");
            }
        }

// 6: Prints out the rules of the game (EXTRA)
        System.out.println(" ");
        System.out.println("- GAME INFORMATION -"); 
        System.out.println("The goal of this game, Blackjack, is fairly simple. Your goal is to get your hand value as close to 21 as possible, without overshooting");
        System.out.println(" ");
        System.out.println("Every round, each player chooses to either |Hit| or |Pass|.");
        System.out.println("Choosing |Hit| draws a card, getting you closer to 21, but you also risk overshooting.");
        System.out.println("Choosing |Pass| has your turn skipped. You choose this when you are either happy with your hand, or don't want to risk overshooting.");
        System.out.println(" ");
        System.out.println("Please note that this version of Blackjack has a set amount of rounds, ");
        System.out.println("unlike regular Blackjack, where the game ends when everyone chooses to |Pass|, ( or for the real game, |Stay| )");
        System.out.println(" ");
        System.out.println("And one more thing, here are the values for the following cards:");
        System.out.println("Queens = 11");
        System.out.println("Kings = 12");
        System.out.println("Aces = 1");
        System.out.println("The rest of the card values are defined by their numbered value (Ex. 8 of Spades is worth 8 points!)");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Are you ready to play? Input 1 to continue!");
        if (UserI.hasNextInt()) {
            FRules = UserI.nextInt();
            if (FRules == 1){
            } else {                
                System.out.println("Incorrect Input! Please enter a number 1 through 5!");
            }
        }

// 7 : Prints out the start of the card game (EXTRA)
        System.out.println(" ");
        System.out.println("BLACK JACK : START"); 
        System.out.println("-------------------------------"); 

// 8:  Replays the turn system depending on the round amount
        for (int r = 1; r <= roundCount; r++) {
            System.out.println(" ");
            System.out.println("STANDING FOR ROUND " + r);
            System.out.println("-------------------------------");

    // - Player 1's hand, along with its overall value
            System.out.println("Player 1's Hand");
            for (NCardClass Card : Player1) {
                System.out.println(Card); 
            }   
            for (NCardClass Card : Player1) {
                sPlayer1sum += Card.getValue();
            }       
            System.out.println("Total Hand Value " + sPlayer1sum);
            System.out.println("-------------------------------"); 

    // - Player 2's hand, along with its overall value       
            System.out.println("Player 2's Hand");
            if (playerCount <= 1) {
                for (NCardClass Card : RCPlayer2) {
                    System.out.println(Card); 
                }   
                for (NCardClass Card : Player2) {
                    sPlayer2sum += Card.getValue();
                }
            } else {
                for (NCardClass Card : Player2) {
                    System.out.println(Card); 
                }  
                for (NCardClass Card : Player2) {
                    sPlayer2sum += Card.getValue();
                }
                System.out.println("Total Hand Value " + sPlayer2sum);
            }    
            System.out.println("-------------------------------"); 
    
    // - Player 3's hand, along with its overall value
            System.out.println("Player 3's Hand");
            if (playerCount <= 2) {
                for (NCardClass Card : RCPlayer3) {
                    System.out.println(Card); 
                }  
                for (NCardClass Card : Player3) {
                    sPlayer3sum += Card.getValue();
                } 
            } else {
                for (NCardClass Card : Player3) {
                    System.out.println(Card); 
                }  
                for (NCardClass Card : Player3) {
                    sPlayer3sum += Card.getValue();
                }
                System.out.println("Total Hand Value " + sPlayer3sum);
            }    
            System.out.println("-------------------------------"); 

    // - Player 4's hand, along with its overall value
            System.out.println("Player 4's Hand");
            if (playerCount <= 3) {
                for (NCardClass Card : RCPlayer4) {
                    System.out.println(Card); 
                }  
                for (NCardClass Card : Player4) {
                    sPlayer4sum += Card.getValue();
                } 
            } else {
                for (NCardClass Card : Player4) {
                    System.out.println(Card); 
                }  
                for (NCardClass Card : Player4) {
                    sPlayer4sum += Card.getValue();
                }
                System.out.println("Total Hand Value " + sPlayer4sum);
            }       
            System.out.println("-------------------------------"); 

    // - Player 5's hand, along with its overall value
            System.out.println("Player 5's Hand");
            if (playerCount <= 4) {
                for (NCardClass Card : RCPlayer5) {
                    System.out.println(Card); 
                }  
                for (NCardClass Card : Player5) {
                    sPlayer5sum += Card.getValue();
                } 
            } else {
                for (NCardClass Card : Player5) {
                    System.out.println(Card); 
                }  
                for (NCardClass Card : Player5) {
                    sPlayer5sum += Card.getValue();
                }
            System.out.println("Total Hand Value " + sPlayer5sum);
            }       
            sPlayer1sum -= sPlayer1sum;
            sPlayer2sum -= sPlayer2sum;
            sPlayer3sum -= sPlayer3sum;
            sPlayer4sum -= sPlayer4sum;
            sPlayer5sum -= sPlayer5sum;
            System.out.println("-------------------------------"); 

    // - Player 1's Turn    
            System.out.println(" PLAYER 1's TURN "); 
            System.out.println(" |Hit| or |Pass|? ");
            System.out.println(" Type 1 to |Hit| ");
            System.out.println(" Type 2 to |Pass| ");  
            System.out.println(" Please Insert 1 or 2 "); 
            if (UserI.hasNextInt()) {
                player1Com = UserI.nextInt();
                if (player1Com >=0 && player1Com <=2){
                } else {                
                System.out.println("Incorrect Input! Please enter a 1 or a 2!");
                }
            }
            System.out.println("-------------------------------"); 

    // - Player 1's action
            if (player1Com == 1)    {
                System.out.println("Player 1: [Hit] ");
                System.out.println(" ");
                RCPlayer1.addAll(NewDeck.subList(NCardi, OCardi));
                Player1.addAll(NewDeck.subList(NCardi, OCardi));
                System.out.println("- New Player 1 Deck -" );
                for (NCardClass Card : Player1) {
                    System.out.println(Card); 
                }   
            } else {
                System.out.println("Player 1: [Pass] ");
                System.out.println(" ");
            }
            NCardi +=1;
            OCardi +=1;

    // - Player 2's Turn
            if (playerCount >= 2) {
                System.out.println("-------------------------------");     
                System.out.println(" PLAYER 2's TURN "); 
                System.out.println(" |Hit| or |Pass|? ");
                System.out.println(" Type 1 to |Hit| ");
                System.out.println(" Type 2 to |Pass| ");  
                System.out.println(" Please Insert 1 or 2 "); 
                if (playerCount >= 2) {
                    if (UserI.hasNextInt()) {
                        player2Com = UserI.nextInt();
                        if (player2Com >=0 && player2Com <=2){
                        } else {                
                            System.out.println("Incorrect Input! Please enter a 1 or a 2!");
                        }
                    }
                } else {
                    randomizer = randomC.nextInt(2);
                    player2Com = randomizer;
                }
            } else {
                System.out.println("-------------------------------"); 
                System.out.println(" PLAYER 2's TURN ");
            }

    // - Player 2's action
            System.out.println("-------------------------------"); 
            if (player2Com == 1)    {
                System.out.println("Player 2: [Hit] ");
                System.out.println(" ");
                RCPlayer2.addAll(NewDeck.subList(NCardi, OCardi));
                Player2.addAll(NewDeck.subList(NCardi, OCardi));
                if (playerCount <= 1) {
                    System.out.println("- New Player 2 Deck -" );
                    for (NCardClass Card : Player2) {
                        System.out.println(Card); 
                    } 
                }    
            } else {
                System.out.println("Player 2: [Pass] ");
                System.out.println(" ");
            }
            NCardi +=1;
            OCardi +=1;

    // - Player 3's Turn
            if (playerCount >= 3) {
                System.out.println("-------------------------------"); 
                System.out.println(" PLAYER 3's TURN "); 
                System.out.println(" |Hit| or |Pass|? ");
                System.out.println(" Type 1 to |Hit| ");
                System.out.println(" Type 2 to |Pass| ");  
                System.out.println(" Please Insert 1 or 2 "); 
                if (playerCount >= 3) {
                    if (UserI.hasNextInt()) {
                        player3Com = UserI.nextInt();
                        if (player3Com >=0 && player3Com <=2){
                        } else {                
                            System.out.println("Incorrect Input! Please enter a 1 or a 2!");
                        }
                    }
                } else {
                    randomizer = randomC.nextInt(2);
                    player3Com = randomizer;
                }
            } else {
                System.out.println("-------------------------------"); 
                System.out.println(" PLAYER 3's TURN ");
            }

    // - Player 3's action
            System.out.println("-------------------------------"); 
            if (player3Com == 1)    {
                System.out.println("Player 3: [Hit] ");
                System.out.println(" ");
                RCPlayer3.addAll(NewDeck.subList(NCardi, OCardi));
                Player3.addAll(NewDeck.subList(NCardi, OCardi));
                if (playerCount >= 3) {
                    System.out.println("- New Player 3 Deck -" );
                    for (NCardClass Card : Player3) {
                        System.out.println(Card); 
                    }
                }   
            } else {
                System.out.println("Player 3: [Pass] ");
                System.out.println(" ");
            }
            NCardi +=1;
            OCardi +=1;

    // - Player 4's Turn 
            if (playerCount >= 4) {
                System.out.println("-------------------------------"); 
                System.out.println(" PLAYER 4's TURN "); 
                System.out.println(" |Hit| or |Pass|? ");
                System.out.println(" Type 1 to |Hit| ");
                System.out.println(" Type 2 to |Pass| ");  
                System.out.println(" Please Insert 1 or 2 "); 
                if (playerCount >= 4) {
                    if (UserI.hasNextInt()) {
                        player4Com = UserI.nextInt();
                        if (player4Com >=0 && player4Com <=2){
                        } else {                
                            System.out.println("Incorrect Input! Please enter a 1 or a 2!");
                        }
                    }
                } else {
                    randomizer = randomC.nextInt(2);
                    player4Com = randomizer;
                }
            } else {
                System.out.println("-------------------------------"); 
                System.out.println(" PLAYER 4's TURN ");
            }

    // - Player 4's action
            System.out.println("-------------------------------"); 
            if (player4Com == 1)    {
                System.out.println("Player 4: [Hit] ");
                System.out.println(" ");
                RCPlayer4.addAll(NewDeck.subList(NCardi, OCardi));
                Player4.addAll(NewDeck.subList(NCardi, OCardi));
                if (playerCount <= 3) {
                    System.out.println("- New Player 4 Deck -" );
                    for (NCardClass Card : Player4) {
                        System.out.println(Card); 
                    }  
                } 
            } else {
                System.out.println("Player 4: [Pass] ");
                System.out.println(" ");
            }
            NCardi +=1;
            OCardi +=1;

    // - Player 5's Turn  
            if (playerCount >= 5) {
                System.out.println("-------------------------------"); 
                System.out.println(" PLAYER 5's TURN "); 
                System.out.println(" |Hit| or |Pass|? ");
                System.out.println(" Type 1 to |Hit| ");
                System.out.println(" Type 2 to |Pass| ");  
                System.out.println(" Please Insert 1 or 2 "); 
                if (playerCount >= 5) {
                    if (UserI.hasNextInt()) {
                        player5Com = UserI.nextInt();
                        if (player5Com >=0 && player5Com <=2){
                        } else {                
                            System.out.println("Incorrect Input! Please enter a 1 or a 2!");
                        }
                    }
                } else {
                    randomizer = randomC.nextInt(2);
                    player5Com = randomizer;
                }
            } else {
                System.out.println("-------------------------------"); 
                System.out.println(" PLAYER 5's TURN ");
            }

    // - Player 5's action
            System.out.println("-------------------------------"); 
            if (player5Com <= 1)    {
                System.out.println("Player 5: [Hit] ");
                System.out.println(" ");
                RCPlayer5.addAll(NewDeck.subList(NCardi, OCardi));
                Player5.addAll(NewDeck.subList(NCardi, OCardi));
                if (playerCount >= 5) {
                    System.out.println("- New Player 5 Deck -" );
                    for (NCardClass Card : Player4) {
                        System.out.println(Card); 
                    }
                }   
            } else {
                System.out.println("Player 5: [Pass] ");
                System.out.println(" ");
            }
            System.out.println("-------------------------------");
        }


// 9: Prints out the results
    System.out.println("THE ROUND LIMIT HAS BEEN REACHED");
    System.out.println(" ");
    System.out.println("Calculating final results...");
    System.out.println(" ");

    for (NCardClass Card : Player1) {
        Player1sum += Card.getValue();
    }  
    for (NCardClass Card : Player2) {
        Player2sum += Card.getValue();
    }  
    for (NCardClass Card : Player3) {
        Player3sum += Card.getValue();
    }  
    for (NCardClass Card : Player4) {
        Player4sum += Card.getValue();
    }  
    for (NCardClass Card : Player5) {
        Player5sum += Card.getValue();
    }  
    System.out.println("FINAL RESULTS");
    System.out.println("PLAYER 1'S HAND VALUE " + Player1sum);
    System.out.println("PLAYER 2'S HAND VALUE " + Player2sum);
    System.out.println("PLAYER 3'S HAND VALUE " + Player3sum);
    System.out.println("PLAYER 4'S HAND VALUE " + Player4sum);
    System.out.println("PLAYER 5'S HAND VALUE " + Player5sum);


// 10: Determines the winning hand
    System.out.println("MEANING THE WINNER IS. . ."); 
    int WinningValue;
    WinningValue = 0;
    if (Player1sum > WinningValue)  {
        if (Player1sum <= 21 ) {
            WinningValue = Player1sum;
        }
    }
    if (Player2sum > WinningValue)  {
        if (Player2sum <= 21 ) {
            WinningValue = Player2sum;
        }
    }
    if (Player3sum > WinningValue)  {
        if (Player3sum <= 21 ) {
            WinningValue = Player3sum;
        }
    }
    if (Player4sum > WinningValue)  {
        if (Player4sum <= 21 ) {
            WinningValue = Player4sum;
        }
    }
    if (Player5sum > WinningValue)  {
        if (Player5sum <= 21 ) {
            WinningValue = Player5sum;
        }
    }
    if (Player1sum == WinningValue)  {
        System.out.println("PLAYER 1 WITH " + Player1sum + " POINTS!");
    }
    if (Player2sum == WinningValue)  {
        System.out.println("PLAYER 2 WITH " + Player2sum + " POINTS!");
    }
    if (Player3sum == WinningValue)  {
        System.out.println("PLAYER 3 WITH " + Player3sum + " POINTS!");
    }
    if (Player4sum == WinningValue)  {
        System.out.println("PLAYER 4 WITH " + Player4sum + " POINTS!");
    }
    if (Player5sum == WinningValue)  {
        System.out.println("PLAYER 5 WITH " + Player5sum + " POINTS!");
    }
    if (WinningValue == 0)  {
        System.out.println("NO CONTEST: EVERY PLAYER OVERSHOT 21!");
    }


// 11: Ends the game [EXTRA]
    System.out.println("-------------------------------"); 
    System.out.println("[END GAME]"); 
    System.out.println(" "); 
    UserI.close();


    }
}
     

