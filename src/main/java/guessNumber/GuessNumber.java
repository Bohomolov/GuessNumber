package guessNumber;

import java.util.Random;
import java.util.Scanner;

import static utils.Constants.*;

public class GuessNumber {
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private final Scanner scanner2 = new Scanner(System.in);

    private int min;
    private int max;
    private int randomNumber;
    private int attempt;
    private String playerAnswerStr;
    private int playerAnswer;
    private int lastAnswer;

    public void run() {
        System.out.println(GREETINGS);
        System.out.println(SET_MIN);
        min = scanner.nextInt();
        System.out.println(SET_MAX);
        max = scanner.nextInt();
        System.out.println(SET_ATTEMPTS);
        attempt = scanner.nextInt();
        if (min < 1 || max > 200 || max < min || attempt > 15 || attempt < 1) {
            throw new IllegalArgumentException(EXCEPTION);
        }
        randomNumber = random.nextInt((max + 1) - min) + min;
        System.out.println(LET_PLAY);

        while (true) {

            playerAnswer = scanner.nextInt();
            if (playerAnswer == randomNumber) {
                System.out.println(CONGRATULATION);
                break;
            }
            if (playerAnswer == 9379992) {
                System.out.println(EXIT_MESSAGE);
                playerAnswerStr = scanner2.nextLine();
                if (playerAnswerStr.equalsIgnoreCase(YES)){
                    System.exit(0);
                }else if (playerAnswerStr.equalsIgnoreCase(NO)){
                    System.out.println(LET_PLAY);
                    continue;
                }

            } else {

                if (lastAnswer != 0) {
                    if (Math.abs(lastAnswer - randomNumber) > Math.abs(playerAnswer - randomNumber)) {
                        System.out.println(WARMER);
                    } else {
                        System.out.println(COLDER);
                    }
                }
                lastAnswer = playerAnswer;
                attempt--;
                System.out.printf(MISS_MESSAGE, attempt);
            }
            if (attempt == 0) {
                System.out.printf(LOSE_MESSAGE, randomNumber);
                break;
            }
        }
    }

}
