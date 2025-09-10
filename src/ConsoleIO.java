import java.util.Scanner;

public class ConsoleIO {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine() {
        return scanner.nextLine().trim();
    }

    public static boolean[] chooseDiceToReroll(int count) {
        System.out.print("Enter dice numbers to reroll (1-" + count + "), separated by space, or nothing to keep all: ");
        String input = readLine();
        boolean[] reroll = new boolean[count];
        if (!input.isEmpty()) {
            String[] parts = input.split("\\s+");
            for (String p : parts) {
                try {
                    int idx = Integer.parseInt(p) - 1;
                    if (idx >= 0 && idx < count) reroll[idx] = true;
                } catch (NumberFormatException e) {
                    System.out.println("Ignoring invalid input: " + p);
                }
            }
        }
        return reroll;
    }
}
