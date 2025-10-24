package part1;

import java.util.ArrayList;
import java.util.Collections;

public class Chat {
    ArrayList<String> history;
    public Chat() {
        history = new ArrayList<>();
    }
    public void push(String message) {
        String[] words = message.split(" ");
        Collections.addAll(history, words);
    }
    public ArrayList<String> getHistory() {
        return history;
    }
}
