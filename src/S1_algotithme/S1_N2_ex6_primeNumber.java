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
public class S1_N2_ex6_primeNumber {
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
	 * method to calculate if the number is prime
	 * 
	 * @param number
	 * @return
	 */
	private static boolean checkNumber(Long number) {
		// int cpt = 0;
		// int tmp;
		if (number < 2) {
			return false;
		}
		for (Long i = number - 1; i >= 2; i--) {
			Long tmp = number % i;
			if (tmp == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * method to check what number is prime before the user number
	 * 
	 * @param number
	 * @return
	 */
	private static String checkBeforePrimeNumber(Long number) {
		String str = "";
		for (Long i = 2L; i < number; i++) {
			boolean tmp = checkNumber(i);
			if (tmp) {
				if (!str.equals("")) {
					str += " - ";
				}
				str += i;
			}
		}
		return str;
	}

	/**
	 * main body to display if the number is prime
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(
				"Welcome, here you can check if a number is prime and to display all prime numbers before this.");
		nb = userInputInt("What number do you want to check ?");
		System.out.println("the number " + nb + " is " + (checkNumber(nb) ? "" : "not ") + "prime.");
		String result = checkBeforePrimeNumber(nb);
		if (result.equals("")) {
			result = "no prime number";
		}
		System.out.println("List of prime numbers less than " + nb + " : " + result + ".");
	}

}
