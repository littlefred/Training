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
public class S1_N3_ex5_christmasTree {
	private static int nbFloor; // attribute to save the number of the floor of the tree

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
				if (result >= 5 && result <= 25) {
					answer = true;
				} else {
					System.err.println("Please could you indicate a number between 5 and 25.");
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
	 * method to fully display the Christmas tree
	 * 
	 * @param nbFloor
	 */
	private static void displayTree(int nbFloor) {
		for (int i = 0; i != nbFloor; i++) {
			int space = nbFloor - i - 1;
			int sharp = nbFloor - space;
			displayFloor(sharp, space);
		}
		displayTrunk(nbFloor);
	}

	/**
	 * method to display a floor of Christmas tree
	 * 
	 * @param sharp
	 * @param space
	 */
	private static void displayFloor(int sharp, int space) {
		String str = "";
		for (int i = 0; i != space; i++) {
			str += " ";
		}
		for (int i = 0; i != sharp; i++) {
			str += "#";
		}
		for (int i = 0; i != sharp - 1; i++) {
			str += "#";
		}
		System.out.println(str);
	}

	/**
	 * method to display the trunk of the Christmas tree
	 * 
	 * @param nbFloor
	 */
	private static void displayTrunk(int nbFloor) {
		String str = "";
		int widthTrunk = nbFloor / 5;
		int space = nbFloor - 1 - widthTrunk;
		for (int j = 0; j != space; j++) {
			str += " ";
		}
		for (int j = 0; j != widthTrunk + 1; j++) {
			str += "#";
		}
		for (int j = 0; j != widthTrunk; j++) {
			str += "#";
		}
		System.out.println(str);
		str = "";
	}

	/**
	 * main body to display the Christmas Tree
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome, here you can display a christmas tree.");
		nbFloor = userInputInt(
				"how much floor do you want for the christmas tree ?\n(please to indicate a number between 5 and 25)");
		displayTree(nbFloor);
	}

}
