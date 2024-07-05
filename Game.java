import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private List<Player> players; // Players in the game
    private Deck deck; // Game deck
    private Dice dice; // Six-sided die
    private Card thief; // Stolen item
    private Card location; // Location of theft
    private Card room; // Room where theft occurred
    private Random random; // Random number generator

    public Game(List<String> playerNames) {
        players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name.trim(), Room.LIVING_ROOM)); // Create players
        }
        deck = new Deck(); // Initialize deck
        dice = new Dice(6); // Six-sided die
        random = new Random(); // Random number generator
        displayAllCards(); // Display all cards

        setupGame(); // Prepare game
    }

    private void displayAllCards() {
        System.out.println("\nAll cards:");
        for (Card card : deck.getAllCards()) {
            System.out.println(card.getName() + " " + card.getType());
        }
    }

    private void setupGame() {
        // Assign special cards and distribute others
        thief = deck.drawCard();
        location = deck.drawCard();
        room = deck.drawCard();

        distributeCards(); // Give out remaining cards
    }

    private void distributeCards() {
        int index = 0;
        while (!deck.getCards().isEmpty()) {
            players.get(index).addCard(deck.drawCard()); // Pass cards to players
            index = (index + 1) % players.size();
        }
    }

    public void start(Scanner scanner) {
        boolean won = false;
        while (!won) {
            for (Player player : players) {
                if (playTurn(player, scanner)) { // Play turns until win condition met
                    won = true;
                    break;
                }
            }
        }
    }

    public boolean playTurn(Player player, Scanner scanner) {
        System.out.println("\n" + player.getName() + "'s turn.");
        showPlayerCards(player); // Show player's cards

        int roll = dice.roll(); // Roll dice
        System.out.println(player.getName() + " rolled: " + roll);

        Room target = chooseRoom(player, roll); // Decide room to move to
        return makeGuess(target, player, scanner); // Make a guess
    }

    private void showPlayerCards(Player player) {
        System.out.println("Your cards:");
        for (Card card : player.getCards()) {
            System.out.println(card.getName() + " " + card.getType());
        }
    }

    private Room chooseRoom(Player player, int roll) {
        Room current = player.getCurrentRoom(); // Assume getCurrentRoom() exists
        Room nextEven = current.getNextEvenRoom(current);
        Room nextOdd = current.getNextOddRoom(current);

        // Logic to decide room based on roll result
        Room target = roll % 2 == 0 ? nextEven : nextOdd;
        while (target == current || Math.abs(current.getValue() - target.getValue()) <= 1) {
            roll = dice.roll();
            nextEven = current.getNextEvenRoom(current);
            nextOdd = current.getNextOddRoom(current);
            target = roll % 2 == 0 ? nextEven : nextOdd;
        }
        player.setCurrentRoom(target);
        return target;
    }

    private boolean makeGuess(Room target, Player player, Scanner scanner) {
        System.out.println("You are in " + target + ". Guess thief, location, and room:");
        String[] guesses = scanner.nextLine().split(",");

        if (guesses.length == 3) {
            Card guessThief = new Card(guesses[0].trim(), "Character");
            Card guessLocation = new Card(guesses[1].trim(), "Location");
            Card guessRoom = new Card(guesses[2].trim(), "Room");

            if (isCorrectGuess(guessThief, guessLocation, guessRoom)) {
                System.out.println(player.getName() + " wins!");
                return true;
            } else {
                System.out.println("Wrong guess. Game continues.");
                return false;
            }
        } else {
            System.out.println("Invalid input. Enter three guesses.");
            return false;
        }
    }

    private boolean isCorrectGuess(Card guessThief, Card guessLocation, Card guessRoom) {
        return guessThief.equals(thief) && guessLocation.equals(location) && guessRoom.equals(room);
    }
}
