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
public class S1_N2_ex3_PGCD {
	private static int nb1; // attribute to save the first number
	private static int nb2; // attribute to save the second number

	private static Scanner scanner = new Scanner(System.in); // open the scanner

	/**
	 * method to receive the user information since integer
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
				answer = true;
			} catch (InputMismatchException e) {
				System.err.println("Your answer is not a correct number, please try again.");
			} finally {
				scanner.nextLine();
			}
		}
		return result;
	}

	/**
	 * method to calculate the PGCD between two numbers
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static int calculPgcd(int a, int b) {
		if (a < b) {
			int tempA = a;
			a = b;
			b = tempA;
		}
		int result;
		int r = a % b;
		while (r != 0) {
			a = b;
			b = r;
			r = a % b;
		}
		result = b;
		return result;
	}

	/**
	 * main body to display the PGCD
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome, here you can check the PGCD between two numbers.");
		nb1 = userInputInt("What is your first number ?");
		nb2 = userInputInt("What is your second number ?");
		System.out.println("the PGCD between " + nb1 + " et " + nb2 + " est : " + calculPgcd(nb1, nb2) + ".");
	}

}
