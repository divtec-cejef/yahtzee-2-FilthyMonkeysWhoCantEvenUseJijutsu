public class ScoreChecker {

    // ------------------ Pair (Une paire) ------------------
    public static int scorePair(int[] dice) {
        int[] counts = countValues(dice);
        for (int i = 6; i >= 1; i--) { // take highest pair if multiple
            if (counts[i] >= 2) return 5; // fixed 5 points
        }
        return 0;
    }

    // ------------------ Two Pairs (Deux paires) ------------------
    public static int scoreTwoPairs(int[] dice) {
        int[] counts = countValues(dice);
        int pairs = 0;
        for (int i = 1; i <= 6; i++) {
            if (counts[i] >= 2) pairs++;
        }
        return (pairs >= 2) ? 10 : 0;
    }

    // ------------------ Three of a Kind (Brelan) ------------------
    public static int scoreThreeOfKind(int[] dice) {
        int[] counts = countValues(dice);
        for (int i = 1; i <= 6; i++) {
            if (counts[i] >= 3) return i * 3; // sum of the 3 identical dice
        }
        return 0;
    }

    // ------------------ Four of a Kind (Carré) ------------------
    public static int scoreFourOfKind(int[] dice) {
        int[] counts = countValues(dice);
        for (int i = 1; i <= 6; i++) {
            if (counts[i] >= 4) return i * 4; // sum of the 4 identical dice
        }
        return 0;
    }

    // ------------------ Full House ------------------
    public static int scoreFullHouse(int[] dice) {
        int[] counts = countValues(dice);
        boolean hasThree = false, hasTwo = false;
        for (int c : counts) {
            if (c == 3) hasThree = true;
            if (c == 2) hasTwo = true;
        }
        return (hasThree && hasTwo) ? 25 : 0;
    }

    // ------------------ Small Straight (Petite suite) ------------------
    public static int scoreSmallStraight(int[] dice) {
        boolean[] present = new boolean[7]; // 1-6
        for (int d : dice) present[d] = true;

        if ((present[1] && present[2] && present[3] && present[4]) ||
                (present[2] && present[3] && present[4] && present[5]) ||
                (present[3] && present[4] && present[5] && present[6])) {
            return 30;
        }
        return 0;
    }

    // ------------------ Large Straight (Grande suite) ------------------
    public static int scoreLargeStraight(int[] dice) {
        boolean[] present = new boolean[7]; // 1-6
        for (int d : dice) present[d] = true;

        if ((present[1] && present[2] && present[3] && present[4] && present[5]) ||
                (present[2] && present[3] && present[4] && present[5] && present[6])) {
            return 40;
        }
        return 0;
    }

    // ------------------ Yahtzee ------------------
    public static int scoreYahtzee(int[] dice) {
        int first = dice[0];
        for (int d : dice) if (d != first) return 0;
        return 50;
    }

    // ------------------ Helper Methods ------------------
    private static int[] countValues(int[] dice) {
        int[] counts = new int[7]; // index 1-6
        for (int d : dice) counts[d]++;
        return counts;
    }
}