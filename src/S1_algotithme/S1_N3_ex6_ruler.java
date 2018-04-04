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
public class S1_N3_ex6_ruler {
	private static int measure; // attribute to save the measure of the ruler

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
				if (result > 0) {
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
	 * method to display the simple ruler
	 * 
	 * @param measure
	 */
	private static void displaySimpleRuler(int measure) {
		for (int i = 0; i != measure; i++) {
			if (i == 0 || i % 5 == 0 && i == measure - 1) {
				System.out.print("|");
			} else if (i % 5 == 0 && i != measure) {
				System.out.print("+");
			} else {
				System.out.print("-");
			}
		}
		System.out.println();
	}

	/**
	 * method to display the border of the ruler
	 * 
	 * @param measure
	 */
	private static void displayBorderLargeRuler(int measure) {
		for (int i = 0; i != measure; i++) {
			if (i == 0 || i % 5 == 0) {
				System.out.print("+");
			} // else if (i % 5 == 0 && i != measure) {
				// System.out.print("+");
				// }
			else {
				System.out.print("-");
			}
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome, here we can display a ruler in simple version or large version.");
		int userChoice;
		do {
			System.out.println("What do you want to do ?");
			System.out.println("1 - Display a simple ruler.");
			System.out.println("2 - Display a large ruler.");
			System.out.println("3 - Quit the application.");
			userChoice = userInputInt("your choice : ");
			if (userChoice == 1 || userChoice == 2) {
				measure = userInputInt("your measure : ");
			}
			switch (userChoice) {
			case 1:
				displaySimpleRuler(measure);
				break;
			case 2:
				displayBorderLargeRuler(measure);
				displaySimpleRuler(measure);
				displayBorderLargeRuler(measure);
				break;
			case 3:
				System.out.println("Thank you and Goodbye !");
				break;
			default:
				System.err.println("Your choice is not possible, please try again.");
				break;
			}
		} while (userChoice != 3);
	}

}
