import java.util.Arrays;

public class DiceHand {
    private Die[] dice;

    public DiceHand(int count) {
        dice = new Die[count];
        for (int i = 0; i < count; i++) dice[i] = new Die();
    }

    public void rollAll() {
        for (Die d : dice) d.roll();
    }

    public void rollSelected(boolean[] toReroll) {
        for (int i = 0; i < dice.length; i++) {
            if (toReroll[i]) dice[i].roll();
        }
    }

    public int[] getValues() {
        return Arrays.stream(dice).mapToInt(Die::getValue).toArray();
    }

    @Override
    public String toString() {
        return Arrays.toString(getValues());
    }
}
