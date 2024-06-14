import java.util.Random;
import java.util.Scanner;

public class guess_number {
    
    private static final int MAX_ATTEMPTS = 3;
    private static final int MAX_ROUNDS =2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;

        System.out.println("Welcome to the Guess the Number Game!");

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Round " + round + " of " + MAX_ROUNDS);
            System.out.println("I have selected a number between 1 and 100. Try to guess it!");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    int points = (MAX_ATTEMPTS - attempts + 1) * 10; // Points based on remaining attempts
                    totalScore += points;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    System.out.println("You earned " + points + " points.");
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you did not guess the number. The number was " + numberToGuess);
            }

            System.out.println("Your total score after round " + round + " is: " + totalScore);
        }

        System.out.println("Game over! Your final score is: " + totalScore);
        scanner.close();
    }
}

