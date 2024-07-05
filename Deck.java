import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards; // Current deck
    private List<Card> possibleCards; // All possible cards

    public Deck() {
        cards = new ArrayList<>(); // Initialize current and possible cards lists
        possibleCards = new ArrayList<>();
        initializeDeck(); // Set up initial deck
        shuffleDeck(); // Shuffle the deck
    }

    private void initializeDeck() {
        // Populate the deck with character cards
        cards.addAll(List.of(
                new Card("Emma", "Character"),
                new Card("Liam", "Character"),
                new Card("Jack", "Character"),
                new Card("Sophia", "Character"),
                new Card("Emily", "Character"),
                new Card("Ella", "Character")));

        // Add location cards
        cards.addAll(List.of(
                new Card("Under the vase", "Location"),
                new Card("Hidden drawer", "Location"),
                new Card("Behind the picture", "Location"),
                new Card("Inside the box", "Location"),
                new Card("Under the table", "Location"),
                new Card("On top of the wardrobe", "Location")));

        // Include room cards
        cards.addAll(List.of(
                new Card("Greenhouse", "Room"),
                new Card("Billiard room", "Room"),
                new Card("Study room", "Room"),
                new Card("Living room", "Room"),
                new Card("Bedroom", "Room"),
                new Card("Piano room", "Room"),
                new Card("Dining room", "Room"),
                new Card("Kitchen", "Room"),
                new Card("Library", "Room")));

        // Duplicate cards to represent multiple copies
        for (Card card : cards) {
            possibleCards.add(card); // Each card gets added twice to simulate duplicates
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(cards); // Randomize order of cards
    }

    public List<Card> getCards() {
        return cards; // Get current set of cards
    }

    public List<Card> getAllCards() {
        return possibleCards; // Get all possible cards, including duplicates
    }

    public Card drawCard() {
        return cards.remove(cards.size() - 1); // Remove and return last card drawn
    }
}
