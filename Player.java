import java.util.Scanner;

public class Player {
    private static Scanner input = new Scanner(System.in);

    private String name;
    private Word word;

    // Constructor takes inputs from user for name and word
    public Player() {
        input.reset();

        System.out.print("New player, please enter your name: ");
        this.name = input.nextLine();

        System.out.print(this.name + ", please enter a valid, 5 letter word that your opponent will guess: ");
        this.word = new Word(input.nextLine());

        input.reset();
    }

    // Getters
    public Word get_word() {
        return this.word;
    }
    public String get_name() {
        return this.name;
    }
}