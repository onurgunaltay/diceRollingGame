import java.util.Random;
import java.util.Scanner;

public class DiceRollingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        int targetRounds;
        do {
            System.out.println("Enter the target number of rounds (1-99): ");
            targetRounds = scanner.nextInt();
        } while (targetRounds < 1 || targetRounds > 99);

        int[] DICE_POINTS = new int[3]; // Total points of each player
        int round = 1;


        while (round <= targetRounds) {
            System.out.println("Round " + round + ":");


            int[] diceNumbers = new int[3];
            for (int i = 0; i < 3; i++) {
                diceNumbers[i] = random.nextInt(6) + 1; // Random number between 1 and 6
            }


            if (diceNumbers[0] == diceNumbers[1] && diceNumbers[1] == diceNumbers[2]) {
                int bonus = diceNumbers[0];
                for (int i = 0; i < 3; i++) {
                    DICE_POINTS[i] += bonus;
                }
            } else {

                if (diceNumbers[0] != diceNumbers[1] && diceNumbers[1] != diceNumbers[2] && diceNumbers[0] != diceNumbers[2]) {
                    for (int i = 0; i < 3; i++) {
                        DICE_POINTS[i] += diceNumbers[i];
                    }
                } else {

                    int[] sameIndices = new int[2];
                    int diffIndex = -1;
                    for (int i = 0; i < 3; i++) {
                        if (diceNumbers[i] == diceNumbers[(i + 1) % 3]) {
                            sameIndices[0] = i;
                            sameIndices[1] = (i + 1) % 3;
                            diffIndex = (i + 2) % 3;
                            break;
                        }
                    }
                    int bonus = diceNumbers[sameIndices[0]] * 2;
                    DICE_POINTS[sameIndices[0]] += bonus;
                    DICE_POINTS[sameIndices[1]] += bonus;
                    DICE_POINTS[diffIndex] += diceNumbers[diffIndex];
                }
            }


            System.out.println("DICE1---\tDICE2---\tDICE3---\tTOTAL1-\tTOTAL2-\tTOTAL3");
            for (int i = 0; i < 3; i++) {
                System.out.print(diceNumbers[i] + "\t\t\t");
            }
            for (int points : DICE_POINTS) {
                System.out.print(points + "\t\t");
            }
            System.out.println();

            round++;
        }

        scanner.close();
    }
}
