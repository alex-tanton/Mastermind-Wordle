public class Word {
    private String word;
    private boolean[] status;


    /**
     * Creates a word object with attribute of word, which is the string literal of the
     * word, and status, which is an array of booleans representing if any letter has
     * been correctly guessed
     *
     * @param str     The string of the word to be stored
     */
    public Word(String word) {
        this.word = word;
        this.status = new boolean[word.length()];
    }

    /**
     * This method takes a guess for the word and updates status to reflect any
     * correct letters, if all letters correct, return true, else, return false
     *
     * @param guess     The word to be guessed
     * @return          Returns true if word fully guessed
     */
    public boolean make_guess(String guess) {
        for (int i = 0; i < guess.length(); i++) {
            // Exit loop if index out of range error will occur, otherwise update status
            if (this.word.length() == i) { break; }
            // Set status at respective index true if word and guess char matches
            if (this.word.charAt(i) == guess.charAt(i)) { this.status[i] = true; }
        }

        // Return true if all status true, false otherwise
        for(boolean b : this.status) if(!b) return false;
        return true;
    }

    /**
     * This method prints the known letters of a word, substituting an "_"
     * for unknown letters, each letter is separated by a space
     */
    public void display() {
        for (int i = 0; i < this.word.length(); i++) {
            if (this.status[i]) { System.out.print(this.word.charAt(i)); }
            else { System.out.print("_"); }
            System.out.print(" ");
        }
        System.out.println();
    }

    /* GETTERS */

    /**
     * @return     The string literal of the word
     */
    public String get_string() {
        return this.word;
    }
    /**
     * @return     The array of all status values for each letter in word
     */
    public boolean[] get_status() {
        return this.status;
    }
}