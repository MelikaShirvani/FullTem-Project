public class Card {
    private String name;
    private String type; // "Character", "Location", "Room"

    // Constructor sets up name and type
    public Card(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // Returns the name of the card
    public String getName() {
        return name;
    }

    // Returns the type of the card ("Character", "Location", "Room")
    public String getType() {
        return type;
    }

    // Checks if this card is equal to another card by comparing names and types
    @Override
    public boolean equals(Object obj) {
        if (this == obj) // Same object?
            return true;
        if (obj == null || getClass() != obj.getClass()) // Different class or null?
            return false;
        Card other = (Card) obj; // Cast to Card
        return name.equals(other.name) && type.equals(other.type); // Names and types match?
    }

    // Calculates hash code based on name and type
    @Override
    public int hashCode() {
        return name.hashCode() + type.hashCode(); // Combine hashes
    }
}
