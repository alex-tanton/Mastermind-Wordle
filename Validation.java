import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Validation {
    public static String[] validWords = getWords("./words.txt");
    /**
     * This method parses a file, assumed to have one word on each line, and returns
     * an array of type String populated with the words from the file
     *
     * @param fName     Filename of file to be parsed
     * @return          Returns a populated array of words from file
     *                  Returns String[] of length 1, value null if exception occurs
     */
    public static String[] getWords(String fName) {
        try {
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

        } catch (FileNotFoundException e) {
            // Formality for compilation
            System.out.println("words.txt file doesn't exist, program will misbehave.");
            String[] ret = {null};
            return ret;
        }
    }

    /**
     * This method determines if a word is valid, given a list of valid words
     *
     * @param word           Word to be validated
     * @param validWords     List of valid words against which word may be checked
     * @return               true if word is valid, false otherwise
     */
    public static boolean isValid(String word) {
        for (int i = 0; i < validWords.length; i++) {
            if (word.equals(validWords[i])) {
                return true;
            }
        }
        return false;
    }
}