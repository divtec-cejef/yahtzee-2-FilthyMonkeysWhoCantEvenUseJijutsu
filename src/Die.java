import java.util.Random;

public class Die {
    private int value;
    private static final Random random = new Random();

    // Constructor: rolls the die initially
    public Die() {
        roll();
    }

    // Roll the die to get a new value between 1 and 6
    public void roll() {
        value = random.nextInt(6) + 1;
    }

    // Get the current value of the die
    public int getValue() {
        return value;
    }

    // Set the die to a specific value (optional, useful for testing)
    public void setValue(int value) {
        if (value >= 1 && value <= 6) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("Die value must be between 1 and 6");
        }
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}