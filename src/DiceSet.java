import java.util.Random;
import java.util.Arrays;

public class DiceSet {
    private int[] dice;
    private Random random = new Random();

    public DiceSet(int count) {
        dice = new int[count];
    }

    public void rollAll() {
        for (int i = 0; i < dice.length; i++) {
            dice[i] = random.nextInt(6) + 1;
        }
    }

    public int[] getValues() {
        return dice;
    }

    @Override
    public String toString() {
        return Arrays.toString(dice);
    }
}
