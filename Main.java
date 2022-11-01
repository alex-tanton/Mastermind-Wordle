import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Shows instructions for some time then clears
        clear_output();
        System.out.println("WELCOME TO MASTERMIND WORDLE");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println("Critical error in delay.");
            return;
        }
        clear_output();

        // Make 2 players
        Player p1 = new Player();
        clear_output();

        Player p2 = new Player();
        clear_output();

        // Variables for loop
        String guess;
        Player winner;
        int turns = 1;

        Scanner input = new Scanner(System.in);

        // Keep players guessing until one wins
        while (true) {
            // Take player 1 guess after providing word info
            p2.get_word().display();
            System.out.print(p1.get_name() + ", make a guess: ");
            guess = input.nextLine().toUpperCase();
            clear_output();

            // Check if guess is correct, display known letters if incorrect
            if (p2.get_word().make_guess(guess)) { winner = p1; break; }

            // Take player 2 guess after providing word info
            p1.get_word().display();
            System.out.print(p2.get_name() + ", make a guess: ");
            guess = input.nextLine().toUpperCase();
            clear_output();

            // Check if guess is correct, display known letters if incorrect
            if (p1.get_word().make_guess(guess)) { winner = p2; break; }

            turns++;
        }

        input.close();

        System.out.println(winner.get_name() + " won in " + turns + " guesses!");
    }

    // Clears console output, works on most devices, not necessarily all
    public static void clear_output() { System.out.print("\033[H\033[2J"); }
}