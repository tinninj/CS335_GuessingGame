import java.util.*;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int correctNum = random.nextInt(100) + 1;//create random number
        int maxTurns = 3; //max turn each player has to guess

        int currentTurn = 1; //initialize player turn
        int player1Guess; //create player1 and player2 guess
        int player2Guess;
        
        //runs the instructions for the players at the start of the game
        instructions();
        
        //loops as long as the player doesn't run out of turns
        while (currentTurn <= maxTurns) {
            System.out.println("Player 1, it's your turn. What is your guess?");
            player1Guess = checkValidInput(input);//checks if the player input is valid

            if (player1Guess == correctNum) {
                System.out.println("Player 1 wins! The correct answer was " + correctNum);//prints if player guesses correctly
                return;
            } else {
                getHint(player1Guess, correctNum);//give player a hint if they guess wrong
            }

            System.out.println("Player 2, it's your turn. What is your guess?");
            player2Guess = checkValidInput(input);//checks if the player input is valid

            if (player2Guess == correctNum) {
                System.out.println("Player 2 wins! The correct answer was " + correctNum);//prints if player guesses correctly
                return;
            } else {
                getHint(player2Guess, correctNum);//give player a hint if they guess wrong
            }

            currentTurn++; //increments the turn
        }

        System.out.println("Both players lose. The correct answer was " + correctNum);
    }
    
    //instructions for the game
    public static void instructions() {
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("Two players will take turns guessing a number between 1 and 100.");
        System.out.println("Each player has up to 3 turns. The player who guesses correctly wins.");
        System.out.println("If neither player guesses right, then they both lose!");
    }

    //checks that the player enters a interger between 1 and 100
    public static int checkValidInput(Scanner input) {
        int guess;

        while (true) {
            System.out.print("Enter your guess (between 1 and 100): ");
            if (input.hasNextInt()) {// Check if the input is an integer
                guess = input.nextInt();
                if (guess >= 1 && guess <= 100) {// Check if the integer is within 1 to 100
                    break; // Exit the loop if the input is a valid integer
                } else {
                    System.out.print("Invalid input. Enter a number between 1 and 100: ");//error message if input is not valid
                }
            } 
        }

        return guess;
    }

    //gives the player a hint 
    public static void getHint(int g, int c) {
        if (g < c) {
            System.out.println("Your guess is too low. Try again!");
            System.out.println();
        } else {
            System.out.println("Your guess is too high. Try again!");
            System.out.println();
        }
    }
}

