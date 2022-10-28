public class Word {
    private String word;
    private boolean[] status;

    public Word(String str) {
        this.word = str;
        this.status = new boolean[str.length()];
    }

    public boolean take_guess(String str) {
        // Set status at respective index true if word and guess char matches
        for (int i = 0; i < this.word.length(); i++) {
            if (this.word.charAt(i) == str.charAt(i)) {
                status[i] = true;
            }
        }

        // Return true if all status true, false otherwise
        for(boolean b : status) if(!b) return false;
        return true;
    }

    // Getters
    public String get_word() {
        return this.word;
    }
    public boolean[] get_status() {
        return this.status;
    }
}