import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Mystery Game!");

        System.out.println("Enter the names of the players, separated by commas:");
        String input = scanner.nextLine();
        String[] playerNames = input.split(",");

        // Validate player names
        if (playerNames.length < 3) {
            System.out.println("At least three players are required to play the game.");
            return;
        }

        // Initialize the game with the provided player names
        Game game = new Game(Arrays.asList(playerNames));

        // Start the game
        System.out.println("Let the game begin Good luck to all players.");
        game.start(scanner);

        scanner.close();
    }
}
