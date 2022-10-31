public class Word {
    private String word;
    private boolean[] status;

    // Constructor stores word and an array of letter statuses
    public Word(String str) {
        this.word = str;
        this.status = new boolean[str.length()];
    }

    public boolean make_guess(String str) {
        // Set status at respective index true if word and guess char matches
        for (int i = 0; i < str.length(); i++) {
            // Exit loop if index out of range error will occur
            if (this.word.length() == i) { break; }
            if (this.word.charAt(i) == str.charAt(i)) { this.status[i] = true; }
        }

        // Return true if all status true, false otherwise
        for(boolean b : this.status) if(!b) return false;
        return true;
    }

    // Displays word, using letters for knowns and _ for unknowns
    public void display() {
        for (int i = 0; i < this.word.length(); i++) {
            if (this.status[i]) { System.out.print(this.word.charAt(i)); }
            else { System.out.print("_"); }
            System.out.print(" ");
        }
        System.out.println();
    }

    // Getters
    public String get_string() {
        return this.word;
    }
    public boolean[] get_status() {
        return this.status;
    }
}