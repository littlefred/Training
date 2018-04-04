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
public class S1_N3_ex7_diagonal {
	private static int coordX; // attribute to save the coordinate X of the final point
	private static int coordY; // attribute to save the coordinate Y of the final point

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
	 * method to display the diagonal according to X or Y
	 * 
	 * @param X
	 * @param Y
	 */
	private static void displayDiagonal(int X, int Y) {
		if (X >= Y) {
			displayX(X, Y);
		} else {
			displayY(X, Y);
		}
	}

	/**
	 * method to display the diagonal according to X
	 * 
	 * @param X
	 * @param Y
	 */
	private static void displayX(int X, int Y) {
		int baseSharp = X / Y;
		int rest = X % Y;
		int outRest = Y+1 - rest;
		int result = 0;
		int space = 0;
		String str = "";
		for (int i = 0; i <= Y; i++) {
			for (int j = 0; j != space; j++) {
				str += " ";
				result += 1;
			}
			for (int j = 0; j != baseSharp; j++) {
				str += "#";
				result += 1;
			}
			if (rest != 0) {
				if (rest == outRest) {
					outRest--;
				} else {
					rest--;
					str += "#";
					result += 1;
				}
			}
			System.out.println(str);
			str = "";
			space = result;
			result = 0;
		}
	}

	/**
	 * method to display the diagonal according to Y
	 * 
	 * @param X
	 * @param Y
	 */
	private static void displayY(int X, int Y) {
		int baseSharp = Y / X;
		int rest = Y % X;
		int outRest = X+1 - rest;
		int result = 0;
		int space = 0;
		String str = "";
		for (int i = 0; i <= Y; i++) {
			for (int j = 0; j != space; j++) {
				str += " ";
				result += 1;
			}
			for (int j = 0; j != baseSharp; j++) {
				str += "#";
				result += 1;
			}
			System.out.println(str);
			if (outRest >= rest) {
				outRest--;
			} else {
				rest--;
				i++;
				System.out.println(str);
			}
			str = "";
			space = result;
			result = 0;
		}
	}

	/**
	 * method to display the diagonal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out
				.println("Welcome, here you can display a diagonal since the point (0,0) and a point of your choice.");
		coordX = userInputInt("What your choice for the coordinate X of your point ?");
		coordY = userInputInt("What your choice for the coordinate Y of your point ?");
		displayDiagonal(coordX, coordY);
	}

}
