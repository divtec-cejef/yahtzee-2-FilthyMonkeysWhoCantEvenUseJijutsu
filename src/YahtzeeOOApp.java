import java.util.ArrayList;
import java.util.List;

public class YahtzeeOOApp {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        System.out.print("Enter player name: ");
        players.add(new Player(ConsoleIO.readLine()));

        Game game = new Game(players, 5); // 5 rounds
        game.playGame();
    }
}
