import java.util.*;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int correctNum = random.nextInt(100) + 1;
        int maxTurns = 3;

        int currentTurn = 1;
        int player1Guess;
        int player2Guess;

        instructions();

        while (currentTurn <= maxTurns) {
            System.out.println("Player 1, it's your turn. What is your guess?");
            player1Guess = checkValidInput(input);

            if (player1Guess == correctNum) {
                System.out.println("Player 1 wins! The correct answer was " + correctNum);
                return;
            } else {
                getHint(player1Guess, correctNum);
            }

            System.out.println("Player 2, it's your turn. What is your guess?");
            player2Guess = checkValidInput(input);

            if (player2Guess == correctNum) {
                System.out.println("Player 2 wins! The correct answer was " + correctNum);
                return;
            } else {
                getHint(player2Guess, correctNum);
            }

            currentTurn++;
        }

        System.out.println("Both players lose. The correct answer was " + correctNum);
    }

    public static void instructions() {
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Two players will take turns guessing a number between 1 and 100.");
        System.out.println("Each player has up to 3 turns. The player who guesses correctly wins.");
        System.out.println("If neither player guesses right, then they both lose!");
    }

    public static Integer checkValidInput(Scanner input) {
        int guess;

        do {
            System.out.print("Enter your guess (between 1 and 100): ");
            while (!input.hasNextInt()) {
                System.out.print("Invalid input. Enter a number between 1 and 100: ");
                input.next();
            }
            guess = input.nextInt();
        } while (guess < 1 || guess > 100);
        return guess;
    }

    public static void getHint(int guess, int correctNum) {
        if (guess < correctNum) {
            System.out.println("Your guess is too low. Try again!");
            System.out.println();
        } else {
            System.out.println("Your guess is too high. Try again!");
            System.out.println();
        }
    }
}

