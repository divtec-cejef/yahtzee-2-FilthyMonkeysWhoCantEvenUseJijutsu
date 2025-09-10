import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private int rounds;

    public Game(List<Player> players, int rounds) {
        this.players = players;
        this.rounds = rounds;
    }

    public void playGame() {
        for (int r = 1; r <= rounds; r++) {
            System.out.println("\n=== Round " + r + " ===");
            for (Player p : players) {
                System.out.println("\nPlayer: " + p.getName());
                Round round = new Round(p);
                round.playRound();
                System.out.println("Total score: " + p.getScorecard().getTotalScore());
            }
        }

        System.out.println("\n=== Final Scores ===");
        for (Player p : players) {
            System.out.println(p.getName() + ": " + p.getScorecard().getTotalScore());
        }
    }
}
