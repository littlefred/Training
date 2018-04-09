/**
 * 
 */
package tools;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Frederick
 * 
 *         class to manage the scanner and his exceptions
 */
public abstract class Scan {
	private static Scanner scan = new Scanner(System.in); // opening scanner

	/**
	 * method to receive the user information since String not empty
	 * 
	 * @param message
	 * @return
	 */
	public static String userInputString(String message) {
		String result="";
		boolean answer = false;
		while (!answer) {
			System.out.println(message);
				String tempResult = scan.nextLine();
				if (!tempResult.equals("")) {
					answer = true;
					result = tempResult;
				} else {
					System.err.println("Please to complete the information.");
				}
		}
		return result;
	}

	/**
	 * method to receive the user information since global integer
	 * 
	 * @param message
	 * @return
	 */
	public static int userInputInt(String message) {
		int result = 0;
		boolean answer = false;
		while (!answer) {
			System.out.println(message);
			try {
				result = scan.nextInt();
				answer = true;
			} catch (InputMismatchException e) {
				System.err.println("Your answer is not an integer number, please try again.");
			} finally {
				scan.nextLine();
			}
		}
		return result;
	}

	/**
	 * method to receive the user information since positive integer
	 * 
	 * @param message
	 * @return
	 */
	public static int userInputIntPositive(String message) {
		int result = 0;
		boolean answer = false;
		while (!answer) {
			System.out.println(message);
			try {
				result = scan.nextInt();
				if (result >= 0) {
					answer = true;
				} else {
					System.err.println("Please could you indicate a positive number.");
				}
			} catch (InputMismatchException e) {
				System.err.println("Your answer is not an integer number, please try again.");
			} finally {
				scan.nextLine();
			}
		}
		return result;
	}

	/**
	 * method to receive the user information since positive integer without 0
	 * 
	 * @param message
	 * @return
	 */
	public static int userInputIntPositiveWithout0(String message) {
		int result = 0;
		boolean answer = false;
		while (!answer) {
			System.out.println(message);
			try {
				result = scan.nextInt();
				if (result > 0) {
					answer = true;
				} else {
					System.err.println("Please could you indicate a number greater than 0.");
				}
			} catch (InputMismatchException e) {
				System.err.println("Your answer is not an integer number, please try again.");
			} finally {
				scan.nextLine();
			}
		}
		return result;
	}

	/**
	 * method to receive the user information since double
	 * 
	 * @param message
	 * @return
	 */
	public static double userInputDouble(String message) {
		double result = 0;
		boolean answer = false;
		while (!answer) {
			System.out.println(message);
			try {
				result = scan.nextDouble();
				answer = true;
			} catch (InputMismatchException e) {
				System.err.println("Your answer is not a correct number, please try again.");
			} finally {
				scan.nextLine();
			}
		}
		return result;
	}
	
	/**
	 * method to receive the user information since character
	 * 
	 * @param message
	 * @return
	 */
	public static char userInputChar(String message) {
		char result = 'I';
		boolean answer = false;
		while (!answer) {
			System.out.println(message);
				String tempResult = scan.nextLine();
				if (tempResult.length() == 1) {
					answer = true;
					result = tempResult.charAt(0);
				} else {
					System.err.println("Please could you indicate one character.");
				}
		}
		return result;
	}
}
