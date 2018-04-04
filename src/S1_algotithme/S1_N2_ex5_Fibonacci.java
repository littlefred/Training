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
public class S1_N2_ex5_Fibonacci {
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
	 * method to calculate the number of Fibonacci
	 * 
	 * @param number
	 * @return
	 */
	private static Long calculFibonacci(Long number) {
		if (number > 1) {
			return calculFibonacci(number - 1) + calculFibonacci(number - 2);
		} else if (number == 1) {
			return 1L;
		} else {
			return 0L;
		}
	}

	/**
	 * main body to display the number of Fibonacci
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome, here you can calculate a number of Fibonacci.");
		nb = userInputInt("What number of Fibonacci do you want ?");
		System.out.println("the number " + nb + " of Fibonacci is : " + calculFibonacci(nb) + ".");
	}

}
