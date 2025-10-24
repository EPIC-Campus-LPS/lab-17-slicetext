package part1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Chat chat = new Chat();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while(running) {
            String line = scanner.nextLine();
            if(line.equals("STOP")) {
                running = false;
            } else {
                chat.push(line);
            }
        }
        HashMap<String, Integer> wordMap = new HashMap<>();
        ArrayList<String> words = chat.getHistory();
        for(String word : words) {
            if(!wordMap.containsKey(word.toLowerCase())) {
                wordMap.put(word.toLowerCase(), 0);
            }
            int cur = wordMap.get(word.toLowerCase());
            wordMap.put(word.toLowerCase(), cur + 1);
        }
        System.out.println("Num words: " + words.size());
        System.out.println("Num Unique words: " + wordMap.size());
        if(wordMap.containsKey("the")) {
            System.out.println("'the' appears " + wordMap.get("the") + " times");
        }
        boolean is_lower = true;
        String longest = "";
        for(String word : words) {
            if(!word.toLowerCase().equals(word)) {
                is_lower = false;
            }
            if(word.length() > longest.length()) {
                longest = word;
            }
        }
        System.out.println("All words lowercase: " + is_lower);
        System.out.println("Longest word: " + longest);

        System.out.println("Condensed Chat History:");
        for(Map.Entry<String, Integer> e : wordMap.entrySet()) {
            String word = e.getKey();
            if(word.length() > 3) {
                System.out.println(word);
            }
        }
    }
}
