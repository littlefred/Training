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
public class S1_N1_ex5_sharp {
	private static int sharp; // attribute to save the number of sharp that the user want to display
	private static Scanner scanner = new Scanner(System.in); // open the scanner

	/**
	 * method to receive the user information since integer
	 * 
	 * @param message
	 * @return
	 */
	private static int userInput(String message) {
		int result = 0;
		boolean answer = false;
		while (!answer) {
			System.out.println(message);
			try {
				result = scanner.nextInt();
				if (result > 0) {
					answer = true;
				} else {
					System.err.println("Please try again with a number greater than 0.");
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
	 * method to display sharp
	 * 
	 * @param number
	 */
	private static void displaySharp(int number) {
		String str = "";
		for (int i = 0; i != number; i++) {
			str += "#";
		}
		System.out.println(str);
	}

	/**
	 * main body to display the exercise
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome, here you can display a sequence of sharp.");
		sharp = userInput("How many sharp do you want to display ?");
		displaySharp(sharp);
	}

}
