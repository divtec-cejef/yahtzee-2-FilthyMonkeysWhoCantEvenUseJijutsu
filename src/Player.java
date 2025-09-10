public class Player {
    private String name;
    private Scorecard scorecard;

    public Player(String name) {
        this.name = name;
        this.scorecard = new Scorecard();
    }

    public String getName() {
        return name;
    }

    public Scorecard getScorecard() {
        return scorecard;
    }

    public int chooseCategory(int[] dice) {
        Scorecard sc = getScorecard();
        sc.printAvailableCategories(dice);

        while (true) {
            System.out.print("Choose a combination: ");
            String input = ConsoleIO.readLine();
            try {
                Category c = Category.valueOf(input.toUpperCase().replace(" ", "_"));
                if (sc.isCategoryAvailable(c)) {
                    int score = c.score(dice);
                    sc.addScore(c, score);
                    System.out.println("You scored " + score + " points for " + c);
                    return score;
                }
            } catch (IllegalArgumentException e) {
                // invalid input ignored
            }
            System.out.println("Invalid or already used combination, try again.");
        }
    }
}
