/**
 * 
 */
package consolidation;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Frederick
 * 
 *         game to guess a random number
 *
 */
public class Game {
	private static int score; // attribute to save the number of tests to find the good number

	private static Scanner scanner = new Scanner(System.in); // opening the scanner

	/**
	 * method to receive the user information since int
	 * 
	 * @param message
	 * @return
	 */
	private static int userInputInt(String message) {
		int result = 0;
		boolean answer = false;
		while (!answer) {
			System.out.println(message);
			try {
				result = scanner.nextInt();
				if (result >= 0) {
					answer = true;
				} else {
					System.err.println("Please could you indicate a positive number.");
				}
			} catch (InputMismatchException e) {
				System.err.println("Your answer is not a correct number, please try again.");
			} finally {
				scanner.nextLine();
			}
		}
		return result;
	}

	/**
	 * main body to play the game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int numberToGuess = new Random().nextInt(10); // creation of a random number between 0 and 10
		System.out.println("Welcome to the game to guess a random number.");
		boolean answer = false;
		do {
			System.out.println("Try to find a number between 0 and 10.");
			int proposition = userInputInt("Your proposition : ");
			if (proposition == numberToGuess) {
				score++;
				answer = true;
				System.out.println(
						"Congratulations ! You find the right number " + numberToGuess + " in " + score + " test(s).");
			} else {
				score++;
				System.out.println("Sorry ! You haven't finded the right number, please try again.");
			}
		} while (!answer);
	}

}
