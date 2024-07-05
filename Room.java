public enum Room {
    LIVING_ROOM(1), // Living room
    PIANO_ROOM(2), // Piano room
    GREENHOUSE(3), // Greenhouse
    STUDY_ROOM(4), // Study room
    BILLIARD_ROOM(5), // Billiard room
    BEDROOM(6), // Bedroom
    DINING_ROOM(7), // Dining room
    LIBRARY(8), // Library
    KITCHEN(9); // Kitchen

    private final int value; // Value representing the room

    Room(int value) { // Constructor setting the room's value
        this.value = value;
    }

    public int getValue() { // Getter for the room's value
        return value;
    }

    public Room getNextEvenRoom(Room currentRoom) { // Find next even room
        int totalRooms = values().length; // Total rooms
        int nextEvenOrdinal = (currentRoom.ordinal() + 2) % totalRooms; // Next even ordinal
        return values()[nextEvenOrdinal]; // Return room
    }

    public Room getNextOddRoom(Room currentRoom) { // Find next odd room
        int totalRooms = values().length; // Total rooms
        int nextOddOrdinal = (currentRoom.ordinal() + 1) % totalRooms; // Next odd ordinal
        return values()[nextOddOrdinal]; // Return room
    }
}
