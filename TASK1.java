import java.util.Scanner;
import java.util.Random;

public class TASK1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 3;
        int score = 0;
        int maxAttempts = 5;

        for (int round = 1; round <= rounds; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            System.out.println("Round " + round + ": Guess a number between 1 to 100 : ");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess number: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You've guessed the correct number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try it again.");
                } else {
                    System.out.println("Too high. Try it again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println(
                        "You've reached the maximum number of attempts. The number was " + numberToGuess + ".");
            }
        }

        System.out.println("Game over. Your score is: " + score);
        System.out.println("Thank for playing have a good day");
    }
}