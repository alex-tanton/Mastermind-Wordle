import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Make 2 players
        Player p1 = new Player();
        Player p2 = new Player();

        // Variables for loop
        Scanner input = new Scanner(System.in);
        String guess;
        Player winner;
        int turns = 1;

        // Keep players guessing until one wins
        while (true) {
            // Take player 1 guess
            System.out.print(p1.get_name() + ", make a guess: ");
            guess = input.nextLine();

            // Check if guess is correct, display known letters if incorrect
            if (p2.get_word().make_guess(guess)) { winner = p1; break; }
            p2.get_word().display();
            System.out.println();

            // Take player 2 guess
            System.out.print(p2.get_name() + ", make a guess: ");
            guess = input.nextLine();

            // Check if guess is correct, display known letters if incorrect
            if (p1.get_word().make_guess(guess)) { winner = p2; break; }
            p1.get_word().display();
            System.out.println();

            turns++;
        }

        input.close();

        System.out.println("\n" + winner.get_name() + " won in " + turns + " guesses!");
    }
}