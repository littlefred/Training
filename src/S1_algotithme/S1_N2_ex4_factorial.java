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
public class S1_N2_ex4_factorial {
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
	 * method to calculate the factorial of a number
	 * 
	 * @param number
	 * @return
	 */
	private static Long calculFactorial(Long number) {
		if (number > 1) {
			return number * calculFactorial(number - 1);
		} else {
			return 1L;
		}
	}

	/**
	 * main body to display the factorial
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome, here you can calculate the factorial of a number.");
		nb = userInputInt("What is your number ?");
		System.out.println("the factorial of " + nb + " is : " + calculFactorial(nb) + ".");
	}

}
