package part2;

import java.util.ArrayList;

public class Leaderboard {
    int capacity;
    ArrayList<Score> scoreboard;
    public Leaderboard(int capacity) {
        this.capacity = capacity;
        scoreboard = new ArrayList<>(capacity);
    }
    public void addScore(String name, int score) {
        if(scoreboard.isEmpty()) {
            scoreboard.add(new Score(name, score));
        }
        for(int i = 0; i < scoreboard.size() - 1; i++) {
            if(score >= scoreboard.get(i).getScore() && score >= scoreboard.get(i + 1).getScore()) {
                scoreboard.add(i, new Score(name, score));
            }
        }
        if(scoreboard.size() > capacity) {
            scoreboard.removeLast();
        }
    }
    public int getHighScore() {
        return scoreboard.getFirst().getScore();
    }
    public int getAverageScore() {
        int first = scoreboard.get(scoreboard.size() / 2).getScore();
        if(scoreboard.size() > 1) {
            int second = scoreboard.get(scoreboard.size() - (scoreboard.size() / 2)).getScore();
            return (first + second) / 2;
        } else {
            return first;
        }
    }
    public boolean break1000() {
        return scoreboard.getFirst().getScore() > 1000;
    }
    public void printLeaderboard() {
        for(Score s : scoreboard) {
            System.out.println(s);
        }
    }
}
