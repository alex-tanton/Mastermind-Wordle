import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Validation {
    public static void main(String[] args) {
        try {
            String[] validWords = getWords("words.txt");
            Scanner input = new Scanner(System.in);

            System.out.println("Please enter a 4 letter word for your opponent to guess: ");
            String inputWord = input.next();

            while (!(isValid(inputWord, validWords)) {
                System.out.println("Invalid word. Please enter a valid 4 letter word: ");
                inputWord = input.next();

            // CONTINUE PROGRAM LOGIC HERE, inputWord is valid at this point
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Exiting program.");
            return;
        }
    }


    /**
     * This method parses a file, assumed to have one word on each line, and returns
     * an array of type String populated with the words from the file
     *
     * @param fName                      Filename of file to be parsed
     * @return                           Returns a populated array of words from file
     * @throws FileNotFoundException     Thrown if file of given name doesn't exist
     */
    public static String[] getWords(String fName) throws FileNotFoundException {
        //  Make file object from text file
        File wordsFile = new File(fName);

        // Count the unmber of words in the file
        Scanner wordCounter = new Scanner(wordsFile);
        int wordCount = 0;
        while (wordCounter.hasNextLine()) {
            wordCounter.nextLine();
            wordCount++;
        }
        wordCounter.close();

        // Create an array for the words and populate it line by line from file
        String[] words = new String[wordCount];
        Scanner wordsReader = new Scanner(wordsFile);
        for (int i = 0; i < words.length; i++) {
            words[i] = wordsReader.nextLine();
        }
        wordsReader.close();

        // Return populated array
        return words;
    }

    /**
     * This method determines if a word is valid, given a list of valid words
     *
     * @param word           Word to be validated
     * @param validWords     List of valid words against which word may be checked
     * @return               true if word is valid, false otherwise
     */
    public static boolean isValid(String word, String[] validWords) {
        for (int i = 0; i < validWords.length; i++) {
            if (word.equals(validWords[i])) {
                return true;
            }
        }
        return false;
    }
}