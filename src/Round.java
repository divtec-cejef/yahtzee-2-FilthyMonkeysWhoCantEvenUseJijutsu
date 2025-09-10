import java.util.Arrays;

public class Round {
    private Player player;
    private DiceHand diceHand;

    public Round(Player player) {
        this.player = player;
        this.diceHand = new DiceHand(5);
    }

    public void playRound() {
        diceHand.rollAll();
        System.out.println("Initial roll: " + diceHand);

        for (int i = 1; i <= 2; i++) {
            boolean[] reroll = ConsoleIO.chooseDiceToReroll(5);

            // check if all false
            boolean allFalse = true;
            for (boolean b : reroll) {
                if (b) { allFalse = false; break; }
            }
            if (allFalse) break;

            diceHand.rollSelected(reroll);
            System.out.println("After reroll " + i + ": " + diceHand);
        }


        System.out.println("Final dice: " + diceHand);
        player.chooseCategory(diceHand.getValues());
    }
}
