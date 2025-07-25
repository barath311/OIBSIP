import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int rounds = 0;
        int totalScore = 0;

        System.out.println("🎮 Welcome to the Number Guessing Game!");
        System.out.print("Enter number of rounds you want to play: ");
        int totalRounds = scanner.nextInt();

        while (rounds < totalRounds) {
            int numberToGuess = random.nextInt(100) + 1; // 1 to 100
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessedCorrectly = false;

            System.out.println("\n🔁 Round " + (rounds + 1) + " begins!");
            System.out.println("Guess a number between 1 and 100. You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("✅ Correct! You've guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    int roundScore = 100 - ((attempts - 1) * 10); // More attempts = lower score
                    totalScore += roundScore;
                    System.out.println("🏆 You scored " + roundScore + " points this round.");
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("🔼 Try higher!");
                } else {
                    System.out.println("🔽 Try lower!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts. The correct number was: " + numberToGuess);
                System.out.println("You scored 0 points this round.");
            }

            rounds++;
        }

        System.out.println("\n🎉 Game Over! You played " + totalRounds + " rounds.");
        System.out.println("🧮 Total Score: " + totalScore + " points");
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
