import java.util.Arrays;

public enum Category {
    ONE_PAIR("One Pair"),
    TWO_PAIRS("Two Pairs"),
    THREE_OF_A_KIND("Three of a Kind"),
    FOUR_OF_A_KIND("Four of a Kind"),
    FULL_HOUSE("Full House"),
    SMALL_STRAIGHT("Small Straight"),
    LARGE_STRAIGHT("Large Straight"),
    YAHTZEE("Yahtzee");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

    public int score(int[] dice) {
        int[] counts = new int[7];
        for (int d : dice) counts[d]++;

        switch (this) {
            case ONE_PAIR:
                for (int i = 6; i >= 1; i--) if (counts[i] >= 2) return i * 2;
                return 0;
            case TWO_PAIRS:
                int pairs = 0, sum = 0;
                for (int i = 1; i <= 6; i++)
                    if (counts[i] >= 2) { pairs++; sum += i * 2; }
                return (pairs >= 2) ? sum : 0;
            case THREE_OF_A_KIND:
                for (int i = 1; i <= 6; i++) if (counts[i] >= 3) return i * 3;
                return 0;
            case FOUR_OF_A_KIND:
                for (int i = 1; i <= 6; i++) if (counts[i] >= 4) return i * 4;
                return 0;
            case FULL_HOUSE:
                boolean hasThree = false, hasTwo = false;
                for (int cnt : counts) { if (cnt == 3) hasThree = true; if (cnt == 2) hasTwo = true; }
                return (hasThree && hasTwo) ? 25 : 0;
            case SMALL_STRAIGHT:
                if ((counts[1] >= 1 && counts[2] >= 1 && counts[3] >= 1 && counts[4] >= 1) ||
                        (counts[2] >= 1 && counts[3] >= 1 && counts[4] >= 1 && counts[5] >= 1) ||
                        (counts[3] >= 1 && counts[4] >= 1 && counts[5] >= 1 && counts[6] >= 1))
                    return 30;
                return 0;
            case LARGE_STRAIGHT:
                if ((counts[1] >= 1 && counts[2] >= 1 && counts[3] >= 1 && counts[4] >= 1 && counts[5] >= 1) ||
                        (counts[2] >= 1 && counts[3] >= 1 && counts[4] >= 1 && counts[5] >= 1 && counts[6] >= 1))
                    return 40;
                return 0;
            case YAHTZEE:
                int first = dice[0];
                for (int d : dice) if (d != first) return 0;
                return 50;
        }
        return 0;
    }
}
