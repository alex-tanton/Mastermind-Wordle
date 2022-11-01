import java.util.Scanner;

public class Player {
    private static Scanner input = new Scanner(System.in);

    private String name;
    private Word word;

    /**
     * Creates a player object with attributes of name, which is a string literal of
     * the chosen name for the player (provided by player), and word, which is an object
     * of type Word, created from a string literal of a word inputted by the player
     */
    public Player() {
        input.reset();

        // Take name input
        System.out.print("New player, please enter your name: ");
        this.name = input.nextLine();

        // Take word input
        System.out.print(this.name + ", please enter a valid, 4 letter word that your opponent will attempt guess: ");
        String word_input = input.nextLine().toUpperCase();

        // Ensure word is valid
        while (!(Validation.isValid(word_input))) {
            System.out.print("Invalid word. Please enter a valid, 4 letter word: ");
            word_input = input.nextLine().toUpperCase();
        }

        this.word = new Word(word_input);

        input.reset();
    }

    /* GETTERS */

    /**
     * @return     The word object attributed to this player
     */
    public Word get_word() {
        return this.word;
    }
    /**
     * @return     The string literal of the name of this player
     */
    public String get_name() {
        return this.name;
    }
}