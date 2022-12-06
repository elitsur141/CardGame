import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private ArrayList<Card> cards;
    private int cardsLeft;

    public Deck(String[] ranks, String[] suits, int[] values)
    {
        cards = new ArrayList<Card>();
        // loops through each suit
        for (int i = 0; i < suits.length; i++)
        {
            //loops through each rank of a specific suit
            for (int j = 0; j < ranks.length; j++)
            {
                //add the Card to the cards
                cards.add(new Card(ranks[j], suits[i], values[j]));
            }
        }
        cardsLeft = cards.size();
        shuffle();
    }
    // returns number of cards in the deck
    public int getCardsLeft()
    {
        return cardsLeft;
    }
    // returns true if deck is empty
    public boolean isEmpty()
    {
        if (cardsLeft == 0)
        {
            return true;
        }
        return false;
    }
    // shuffles the Deck
    public void shuffle()
    {
        cardsLeft = cards.size();
        int index;
        for (int i = cardsLeft - 1; i >= 0; i--)
        {
            int newIdx = (int) (Math.random() * (cardsLeft - 2));
            Collections.swap(cards, i, newIdx);
        }
    }
    // deals a card
    public Card deal()
    {
        if (isEmpty())
        {
            return null;
        }
        cardsLeft--;
        return cards.get(cardsLeft);
    }
}
