import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;

public class YahtzeeProcedural {

    private int[] dice;
    private final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    // Track available combinations
    private static Map<String, Boolean> availableCombinations = new LinkedHashMap<>();
    static {
        availableCombinations.put("Une paire", true);
        availableCombinations.put("Deux paires", true);
        availableCombinations.put("Brelan", true);
        availableCombinations.put("Carré", true);
        availableCombinations.put("Full House", true);
        availableCombinations.put("Petite suite", true);
        availableCombinations.put("Grande suite", true);
        availableCombinations.put("Yahtzee", true);
    }

    public YahtzeeProcedural(int count) {
        dice = new int[count];
    }

    public void rollOne(int index) {
        if (index >= 0 && index < dice.length) {
            dice[index] = random.nextInt(6) + 1;
        } else {
            System.out.println("Index invalide: " + index);
        }
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

    // Ask player which dice to reroll, return null if nothing
    public static String reLaunchExe() {
        System.out.print("Entrez les numéros des dés à relancer (1-5), séparés par espace, ou rien pour garder tous: ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Pas de relance choisie.");
            return null;
        }
        return input;
    }

    // Actually reroll dice based on input
    public void reLaunch(String input) {
        boolean[] reroll = new boolean[dice.length];
        String[] parts = input.split("\\s+");
        for (String p : parts) {
            try {
                int idx = Integer.parseInt(p) - 1;
                if (idx >= 0 && idx < dice.length) reroll[idx] = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide ignorée: " + p);
            }
        }
        for (int i = 0; i < dice.length; i++) {
            if (reroll[i]) dice[i] = random.nextInt(6) + 1;
        }
    }

    // ----------------- Score Checking -----------------
    private static int[] countValues(int[] dice) {
        int[] counts = new int[7];
        for (int d : dice) counts[d]++;
        return counts;
    }

    public static int scorePair(int[] dice) {
        int[] counts = countValues(dice);
        for (int i = 6; i >= 1; i--) if (counts[i] >= 2) return 5;
        return 0;
    }

    public static int scoreTwoPairs(int[] dice) {
        int[] counts = countValues(dice);
        int pairs = 0;
        for (int i = 1; i <= 6; i++) if (counts[i] >= 2) pairs++;
        return (pairs >= 2) ? 10 : 0;
    }

    public static int scoreThreeOfKind(int[] dice) {
        int[] counts = countValues(dice);
        for (int i = 1; i <= 6; i++) if (counts[i] >= 3) return i * 3;
        return 0;
    }

    public static int scoreFourOfKind(int[] dice) {
        int[] counts = countValues(dice);
        for (int i = 1; i <= 6; i++) if (counts[i] >= 4) return i * 4;
        return 0;
    }

    public static int scoreFullHouse(int[] dice) {
        int[] counts = countValues(dice);
        boolean hasThree = false, hasTwo = false;
        for (int c : counts) {
            if (c == 3) hasThree = true;
            if (c == 2) hasTwo = true;
        }
        return (hasThree && hasTwo) ? 25 : 0;
    }

    public static int scoreSmallStraight(int[] dice) {
        boolean[] present = new boolean[7];
        for (int d : dice) present[d] = true;
        if ((present[1] && present[2] && present[3] && present[4]) ||
                (present[2] && present[3] && present[4] && present[5]) ||
                (present[3] && present[4] && present[5] && present[6])) return 30;
        return 0;
    }

    public static int scoreLargeStraight(int[] dice) {
        boolean[] present = new boolean[7];
        for (int d : dice) present[d] = true;
        if ((present[1] && present[2] && present[3] && present[4] && present[5]) ||
                (present[2] && present[3] && present[4] && present[5] && present[6])) return 40;
        return 0;
    }

    public static int scoreYahtzee(int[] dice) {
        int first = dice[0];
        for (int d : dice) if (d != first) return 0;
        return 50;
    }

    public static void printAllScores(int[] dice) {
        System.out.println("Une paire: " + scorePair(dice));
        System.out.println("Deux paires: " + scoreTwoPairs(dice));
        System.out.println("Brelan: " + scoreThreeOfKind(dice));
        System.out.println("Carré: " + scoreFourOfKind(dice));
        System.out.println("Full House: " + scoreFullHouse(dice));
        System.out.println("Petite suite: " + scoreSmallStraight(dice));
        System.out.println("Grande suite: " + scoreLargeStraight(dice));
        System.out.println("Yahtzee: " + scoreYahtzee(dice));
        System.out.println();
    }

    // ----------------- New: Choix de combinaison -----------------
    public static void showAvailableCombinations(int[] dice) {
        System.out.println("Combinaisons disponibles :");
        for (String comb : availableCombinations.keySet()) {
            if (availableCombinations.get(comb)) {
                int score = switch (comb) {
                    case "Une paire" -> scorePair(dice);
                    case "Deux paires" -> scoreTwoPairs(dice);
                    case "Brelan" -> scoreThreeOfKind(dice);
                    case "Carré" -> scoreFourOfKind(dice);
                    case "Full House" -> scoreFullHouse(dice);
                    case "Petite suite" -> scoreSmallStraight(dice);
                    case "Grande suite" -> scoreLargeStraight(dice);
                    case "Yahtzee" -> scoreYahtzee(dice);
                    default -> 0;
                };
                System.out.println(" - " + comb + ": " + score);
            }
        }
    }

    public static void chooseCombination(int[] dice) {
        while (true) {
            showAvailableCombinations(dice);
            System.out.print("Choisissez une combinaison pour marquer vos points: ");
            String choice = scanner.nextLine().trim();
            if (availableCombinations.containsKey(choice) && availableCombinations.get(choice)) {
                int score = switch (choice) {
                    case "Une paire" -> scorePair(dice);
                    case "Deux paires" -> scoreTwoPairs(dice);
                    case "Brelan" -> scoreThreeOfKind(dice);
                    case "Carré" -> scoreFourOfKind(dice);
                    case "Full House" -> scoreFullHouse(dice);
                    case "Petite suite" -> scoreSmallStraight(dice);
                    case "Grande suite" -> scoreLargeStraight(dice);
                    case "Yahtzee" -> scoreYahtzee(dice);
                    default -> 0;
                };
                availableCombinations.put(choice, false); // mark used
                System.out.println("Vous marquez " + score + " points pour " + choice + " !");
                break;
            } else {
                System.out.println("Combinaison invalide ou déjà utilisée, réessayez.");
            }
        }
    }

    // ===== Main =====
    public static void main(String[] args) {
        YahtzeeProcedural game = new YahtzeeProcedural(5);

        // First roll
        game.rollAll();
        System.out.println("Lancer initial: " + game);
        printAllScores(game.getValues());

        // Up to 2 rerolls
        for (int i = 1; i <= 2; i++) {
            String input = reLaunchExe();
            if (input == null) break;        // player skips reroll
            game.reLaunch(input);             // actually reroll dice
            System.out.println("Après relance " + i + ": " + game);
            printAllScores(game.getValues());
        }

        System.out.println("Résultat final: " + game);

        // Jalon 4: choose combination
        chooseCombination(game.getValues());
    }
}
