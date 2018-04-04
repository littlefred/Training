/**
 * 
 */
package S1_algotithme;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Frederick
 *
 */
public class S1_N3_ex1_palindrome {
	private static Long nb; // attribute to save the number

	private static Scanner scanner = new Scanner(System.in); // open the scanner

	/**
	 * method to receive the user information since Long
	 * 
	 * @param message
	 * @return
	 */
	private static Long userInputInt(String message) {
		Long result = 0L;
		boolean answer = false;
		while (!answer) {
			System.out.println(message);
			try {
				result = scanner.nextLong();
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
	 * method to check if a number is a palindrome
	 * 
	 * @param number
	 * @return
	 */
	private static boolean checkPalindrome(Long number) {
		String str = Long.toString(number);
		char[] character = str.toCharArray();
		for (int i = 0; i <= character.length / 2; i++) {
			if (character[i] != (character[character.length - 1 - i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * main body to the application to check a palindrome
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome, here you can check if a number is a palindrome.");
		nb = userInputInt("What number do you want to check ?");
		System.out.println("the number " + nb + " is " + (checkPalindrome(nb) ? "" : "not ") + "a palindrome.");
	}

}
