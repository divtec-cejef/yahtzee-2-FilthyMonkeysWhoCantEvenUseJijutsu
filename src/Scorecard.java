import java.util.EnumMap;
import java.util.Map;

public class Scorecard {
    private Map<Category, ScoreEntry> scores;

    public Scorecard() {
        scores = new EnumMap<>(Category.class);
        for (Category c : Category.values()) {
            scores.put(c, new ScoreEntry(c));
        }
    }

    public boolean isCategoryAvailable(Category c) {
        return !scores.get(c).isUsed();
    }

    public void addScore(Category c, int score) {
        if (!scores.get(c).isUsed()) {
            scores.get(c).setScore(score);
        }
    }

    public int getTotalScore() {
        return scores.values().stream().mapToInt(ScoreEntry::getScore).sum();
    }

    public void printAvailableCategories(int[] dice) {
        System.out.println("Available combinations:");
        for (Category c : Category.values()) {
            if (!scores.get(c).isUsed()) {
                int s = c.score(dice);
                System.out.println(" - " + c + ": " + s);
            }
        }
    }
}
