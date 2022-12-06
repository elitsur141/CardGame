import java.util.ArrayList;
import java.util.Scanner;

public class Game
{
    private Player player1;
    private Player player2;
    private Deck deck;

    public void printInstructions()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("This is the typical game of war. Ace is the lowest value (1) and King is the highest value (13).");
        System.out.print("You and will flip over the top card in your deck, and if it's higher than the computer's card, ");
        System.out.println("you get to keep both cards.");
        System.out.println("But if it's lower than the computer's card, the computer keeps both cards.");
        System.out.println("To win the game, you must get the whole deck of cards.");
        System.out.println("Press enter to take a turn.");
        System.out.println("Press enter to start!");
        input.nextLine();
    }

    // gets the player's names
    public void playerSetup()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Your name:");
        String p1Name = input.nextLine();
        String p2Name = "Computer";
        // makes a hand for each player
        ArrayList<Card> p1Hand = new ArrayList<Card>();
        ArrayList<Card> p2Hand = new ArrayList<Card>();
        // gives each player half the deck
        for (int i = 0; i < deck.getCardsLeft(); i++)
        {
            p1Hand.add(deck.deal());
            p2Hand.add(deck.deal());
        }
        player1 = new Player(p1Name, p1Hand);
        player2 = new Player(p2Name, p2Hand);
    }
    // makes the deck
    public void deckSetup()
    {
        String[] ranks = new String[13];
        int[] values = new int[13];
        String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
        // fill in ranks and values array
        for (int i = 0; i < ranks.length; i++)
        {
            if (i == 0)
            {
                ranks[i] = "A";
                values[i] = 1;
            }
            else if (i < 10)
            {
                ranks[i] = Integer.toString(i + 1);
                values[i] = i + 1;
            }
            else if (i == 10)
            {
                ranks[i] = "Jack";
                values[i] = 11;
            }
            else if (i == 11)
            {
                ranks[i] = "Queen";
                values[i] = 12;
            }
            else if (i == 12)
            {
                ranks[i] = "King";
                values[i] = 13;
            }
        }
        deck = new Deck(ranks, suits, values);
    }
    // plays the game
    public void playGame()
    {
        Scanner input = new Scanner(System.in);
        // while both players still have cards
        while (player1.hasCards() && player2.hasCards())
        {
            // p1's top card
            Card p1Card = player1.getHand().get(0);
            // p2's top card
            Card p2Card = player2.getHand().get(0);
            System.out.println();
            System.out.println("Your top card:");
            System.out.println(p1Card);
            input.nextLine();
            System.out.println("Computer's top card:");
            System.out.println(p2Card);
            input.nextLine();

            // if p1 has higher card
            if (p1Card.getPoint() > p2Card.getPoint())
            {
                // p1 and p2s top card is put at bottom of p1's deck
                player1.addCard(player1.getHand().remove(0));
                player1.addCard(player2.getHand().remove(0));
                System.out.println("You won the round!");
                input.nextLine();
            }

            // if p2 has higher card
            else if (p2Card.getPoint() > p1Card.getPoint())
            {
                // p1 and p2s top card is put at bottom of p2's deck
                player2.addCard(player1.getHand().remove(0));
                player2.addCard(player2.getHand().remove(0));
                System.out.println("The computer won the round :(");
                input.nextLine();
            }

            // if cards have same value
            else
            {
                // each player puts their card at the bottom of their pile
                player1.addCard(player1.getHand().remove(0));
                player2.addCard(player2.getHand().remove(0));
                System.out.println("It's a tie!");
                input.nextLine();
                /*int i = 0;
                while (player1.getHand().get(i).getPoint() == player2.getHand().get(i).getPoint())
                {
                    System.out.println("Rematch time!");
                    Card p1NewCard = player1.getHand().get(i);
                    Card p2NewCard = player2.getHand().get(i);
                    System.out.println("Your new card:");
                    System.out.println(p1NewCard);
                    System.out.println("Computer's new card:");
                    System.out.println(p2NewCard);
                    //if ()
                }*/

            }

            // print statements for the player that is close to winning
            if (player1.getNumCards() < 11)
            {
                if (player1.getNumCards() == 10)
                {
                    System.out.println("You have 10 cards left in your hand!");
                }
                else if (player1.getNumCards() == 5)
                {
                    System.out.println("You have 5 cards left in your hand!");
                }
                else if (player1.getNumCards() == 1)
                {
                    System.out.println("You have 1 card left in your hand!");
                }
                input.nextLine();
            }
            else if (player2.getNumCards() < 11)
            {
                if (player2.getNumCards() == 10)
                {
                    System.out.println("Computer has 10 cards left!");
                }
                else if (player2.getNumCards() == 5)
                {
                    System.out.println("Computer has 5 cards left!");
                }
                else if (player2.getNumCards() == 1)
                {
                    System.out.println("Computer has 1 card left! You're about to win!");
                }
                input.nextLine();
            }

        }
        // if computer won
        if (player1.isEmpty())
        {
            System.out.println("The computer won the game");
        }
        // if user won
        else if (player2.isEmpty())
        {
            System.out.print("Congratulations " + player1.getName() + "!");
            System.out.println("You won the game!");
        }
    }
    // creates players and deck
    public Game()
    {
        printInstructions();
        deckSetup();
        playerSetup();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    }
}
