import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    private int min;
    private int max;
    private int randomNumber;
    private int attempt;
    private int playerAnswer;
    private int arrayCount;
    private int[] playerAnswerArray;

    public void run() {
        System.out.println("Welcome to \"Guess Number\"! You can set the range in which I will guess the number for you.\nAnd you can set the number of attempts per which you will try to guess it.");
        System.out.println("Set minimum value");
        min = scanner.nextInt();
        System.out.println("Set maximum value");
        max = scanner.nextInt();
        System.out.println("Set the number of attempts");
        attempt = scanner.nextInt();
        if (min < 1 || max > 200 || max < min || attempt > 15 || attempt < 1) {
            throw new IllegalArgumentException("Incorrect value! Correct value [1 - 200] and minimum value should be less than maximum value.\nNumbers of attempt should be equals 1 or more and less than 15.");
        }
        randomNumber = random.nextInt((max + 1) - min) + min;
        System.out.println("Let's play!");
        playerAnswerArray = new int[attempt + 1];
        arrayCount = 0;

        while (true) {
            playerAnswer = scanner.nextInt();
            if (playerAnswer == randomNumber) {
                System.out.println("My congratulation! You're win! ");
                break;
            } else {
                playerAnswerArray[arrayCount] = randomNumber;
                arrayCount++;

                attempt--;
                System.out.println("You're miss! Try again. You're have " + attempt + " attempts.");
            }
            if (attempt == 0) {
                System.out.println("You're lost. Guess number was " + randomNumber + ". Bye! See you next time!");
                break;
            }
        }
    }
    
}
