import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name; // Player's name
    private List<Card> cards; // Player's cards
    private Room currentRoom; // Player's current room

    public Player(String name, Room currentRoom) {
        this.name = name; // Name
        this.cards = new ArrayList<>(); // Initialize cards
        this.currentRoom = currentRoom; // Start in room
    }

    public String getName() {
        return name; // Get name
    }

    public List<Card> getCards() {
        return cards; // Get cards
    }

    public void addCard(Card card) {
        cards.add(card); // Add card
    }

    public boolean hasCard(Card card) {
        return cards.contains(card); // Check for card
    }

    public boolean makeGuess(Card guess) {
        return cards.contains(guess); // Make guess if card is present
    }

    public void discardCard(Card card) {
        cards.remove(card); // Discard card
    }

    public Room getCurrentRoom() {
        return currentRoom; // Get current room
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom; // Change room
    }
}
