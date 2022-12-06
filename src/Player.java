import java.util.ArrayList;

public class Player
{
    private String name;
    private ArrayList<Card> hand;
    private int points;

    public Player(String theName)
    {
        name = theName;
        points = 0;
    }

    public Player(String theName, ArrayList<Card> theHand)
    {
        name = theName;
        hand = theHand;
        points = 0;
    }

    public void addPoints(int numPoints)
    {
        points += numPoints;
    }

    public void addCard(Card theCard)
    {
        hand.add(theCard);
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Card> getHand()
    {
        return hand;
    }
    // returns how many cards the player has left
    public int getNumCards()
    {
        return hand.size();
    }
    // returns true if the player still has cards
    public boolean hasCards()
    {
        if (hand.size() > 0)
        {
            return true;
        }
        return false;
    }
    // returns true if the player has no cards
    public boolean isEmpty()
    {
        if (hand.size() == 0)
        {
            return true;
        }
        return false;
    }

    public String toString()
    {
        return name + " has " + points + " points\n" + name + "'s cards: " + hand;
    }
}
