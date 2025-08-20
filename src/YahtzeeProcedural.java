public class YahtzeeProcedural {

        public static void main(String[] args) {
            // Create a 6-sided dice
            DiceSet diceset = new DiceSet(6);

            // Roll it 5 times
        diceset.rollAll();
        System.out.println("Roll: "+  diceset);
            int[] roll = diceset.getValues();

            System.out.println("Une paire: " + ScoreChecker.scorePair(roll));
            System.out.println("Deux paires: " + ScoreChecker.scoreTwoPairs(roll));
            System.out.println("Brelan: " + ScoreChecker.scoreThreeOfKind(roll));
            System.out.println("Carré: " + ScoreChecker.scoreFourOfKind(roll));
            System.out.println("Full House: " + ScoreChecker.scoreFullHouse(roll));
            System.out.println("Petite suite: " + ScoreChecker.scoreSmallStraight(roll));
            System.out.println("Grande suite: " + ScoreChecker.scoreLargeStraight(roll));
            System.out.println("Yahtzee: " + ScoreChecker.scoreYahtzee(roll));

    }
}
